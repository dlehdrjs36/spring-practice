package com.devhistory.springcoreprinciple;

import com.devhistory.springcoreprinciple.member.Grade;
import com.devhistory.springcoreprinciple.member.Member;
import com.devhistory.springcoreprinciple.member.MemberService;
import com.devhistory.springcoreprinciple.order.Order;
import com.devhistory.springcoreprinciple.order.OrderService;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
