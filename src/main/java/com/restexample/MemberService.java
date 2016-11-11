package com.restexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hamz on 11/10/16.
 */
@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getMembers(){
        return memberRepository.findAll();
    }

    public Member findMember(int idMember){
        return memberRepository.findOne(idMember);
    }

    public Member saveMember(Member member){
        Member member1 = findMember(member.getId());
        if (member1 != null){
            throw new MemberExistsException("Data Sudah Ada...!");
        }
        return memberRepository.save(member);
    }

    public Member putMember(Member member) {
        return memberRepository.save(member);
    }

    public Member deleteMember(int idMember){
        Member member = findMember(idMember);
        memberRepository.delete(idMember);
        return member;
    }
}
