package com.devhistory.springcoreprinciple.order;

import com.devhistory.springcoreprinciple.discount.DiscountPolicy;
import com.devhistory.springcoreprinciple.discount.FixDiscountPolicy;
import com.devhistory.springcoreprinciple.discount.RateDiscountPolicy;
import com.devhistory.springcoreprinciple.member.Member;
import com.devhistory.springcoreprinciple.member.MemberRepository;
import com.devhistory.springcoreprinciple.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
//  private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository; // 구현체 의존 제거
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy; // 구현체 의존 제거

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
