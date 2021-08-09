package com.devhistory.springcoreprinciple.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
