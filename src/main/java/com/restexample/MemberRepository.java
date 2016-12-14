package com.restexample;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hamz on 11/10/16.
 */
public interface MemberRepository extends JpaRepository<Member,Integer> {
    Member findByName(String name);
}
