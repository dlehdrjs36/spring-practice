package com.devhistory.springcoreprinciple;

import com.devhistory.springcoreprinciple.discount.FixDiscountPolicy;
import com.devhistory.springcoreprinciple.member.MemberService;
import com.devhistory.springcoreprinciple.member.MemberServiceImpl;
import com.devhistory.springcoreprinciple.member.MemoryMemberRepository;
import com.devhistory.springcoreprinciple.order.OrderService;
import com.devhistory.springcoreprinciple.order.OrderServiceImpl;


public class AppConfig {
    //생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    //생성자 주입
    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
