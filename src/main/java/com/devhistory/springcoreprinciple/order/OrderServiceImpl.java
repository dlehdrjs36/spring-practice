package com.devhistory.springcoreprinciple.order;

import com.devhistory.springcoreprinciple.discount.DiscountPolicy;
import com.devhistory.springcoreprinciple.discount.FixDiscountPolicy;
import com.devhistory.springcoreprinciple.discount.RateDiscountPolicy;
import com.devhistory.springcoreprinciple.member.Member;
import com.devhistory.springcoreprinciple.member.MemberRepository;
import com.devhistory.springcoreprinciple.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
//  private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository; // 구현체 의존 제거
//  private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//  private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy; // 구현체 의존 제거

    //수정자 주입
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        System.out.println("의존관계 주입 발생 순서 : memberRepository = " + memberRepository);
        this.memberRepository = memberRepository;
    }

    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        System.out.println("의존관계 주입 발생 순서 : discountPolicy = " + discountPolicy);
        this.discountPolicy = discountPolicy;
    }

    //생성자 주입
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        System.out.println("(생성자 주입은 호출 시 발생)의존관계 주입 발생 순서 : OrderServiceImpl" );
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    public OrderServiceImpl(){

    }

    //메서드 주입
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
