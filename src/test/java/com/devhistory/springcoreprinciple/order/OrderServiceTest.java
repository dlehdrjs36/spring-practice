package com.devhistory.springcoreprinciple.order;

import com.devhistory.springcoreprinciple.AppConfig;
import com.devhistory.springcoreprinciple.discount.FixDiscountPolicy;
import com.devhistory.springcoreprinciple.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("필드 주입 사용 시, 테스트 어려움(Repository 임의로 생성해서 확인하는 것이 어렵다. 변경을 위해 setter가 필요해진다.)")
    void fieldInjectionTest() {
        //Setter가 추가될 것이라면 필드 주입보다는 Setter 주입으로 사용하는 것이 좋다.
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.setMemberRepository(new MemoryMemberRepository());
//        orderService.setDiscountPolicy(new FixDiscountPolicy());
//        orderService.createOrder(1L, "itemA", 10000);
    }
}