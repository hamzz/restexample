package com.restexample;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatabaseTestConfig.class)
@SpringBootTest
public class RestexampleApplicationTests {

	@Autowired
    private MemberService memberService;

	private Member member;

	@Before
	@Rollback
	public void setup(){
		member = new Member();
		member.setName("Hamzah");
		member.setAge(20);
		member = memberService.saveMember(member);
    }

    @Test
    public void testFindOne(){
        Member hamzah = memberService.findMember(member.getId());
        assertEquals(member.getName(),hamzah.getName());
    }

    @Test
	public void testAge(){
		Member member = new Member();
		member.setName("Adit");
		member.setAge(27);
		assertEquals(memberService.saveMember(member).getAge(),member.getAge());
	}
}
