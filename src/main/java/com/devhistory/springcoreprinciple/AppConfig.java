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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//스프링 구성정보(해당 구성 정보들이 스프링 컨테이너에 등록된다. 구성 정보는 여러개 존재할 수 있다.)
@Configuration
public class AppConfig {

    //memberService 역할, 생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //orderService 역할, 생성자 주입
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //memberRepository 역할
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    //discountPolicy 역할
    @Bean
    public DiscountPolicy discountPolicy() {
//      return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
