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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RestexampleApplication.class)
@SpringBootTest
public class RestexampleApplicationTests {

	@Autowired
    private MemberService memberService;

	private Member member;

	@Before
	public void setup(){
		member = new Member();
		member.setName("Hamzah");
		member = memberService.saveMember(member);
    }

	@Test
	@Transactional
	public void testFind(){
		List<Member> memberList = memberService.getMembers();
        assertNotNull(memberList);
        assertEquals(1,memberList.size());
	}

    @Test
    public void testFindOne(){
        Member hamzah = memberService.findMember(member.getId());
        assertEquals(member.getName(),hamzah.getName());
    }

}
