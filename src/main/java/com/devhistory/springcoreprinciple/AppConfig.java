package com.devhistory.springcoreprinciple;

import com.devhistory.springcoreprinciple.discount.DiscountPolicy;
import com.devhistory.springcoreprinciple.discount.FixDiscountPolicy;
import com.devhistory.springcoreprinciple.discount.RateDiscountPolicy;
import com.devhistory.springcoreprinciple.member.MemberRepository;
import com.devhistory.springcoreprinciple.member.MemberService;
import com.devhistory.springcoreprinciple.member.MemberServiceImpl;
import com.devhistory.springcoreprinciple.member.MemoryMemberRepository;
import com.devhistory.springcoreprinciple.order.OrderService;
import com.devhistory.springcoreprinciple.order.OrderServiceImpl;


public class AppConfig {
    //memberService 역할, 생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //orderService 역할, 생성자 주입
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //memberRepository 역할
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //discountPolicy 역할
    public DiscountPolicy discountPolicy() {
//      return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
