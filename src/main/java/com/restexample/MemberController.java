package com.restexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hamz on 11/10/16.
 */
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/members")
    List<Member> members() {
        return memberService.getMembers();
    }

    @RequestMapping(value = "/members/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Integer id) {
        memberService.deleteMember(id);
    }
}
