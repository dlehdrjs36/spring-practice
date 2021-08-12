package com.devhistory.springcoreprinciple;

import com.devhistory.springcoreprinciple.member.Grade;
import com.devhistory.springcoreprinciple.member.Member;
import com.devhistory.springcoreprinciple.member.MemberService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        MemberService memberService = new MemberServiceImpl();

        /*
            스프링 컨테이너 생성(애노테이션 기반으로 구성 설정)
            - 인자로 전달한 AppConfig의 환경설정 정보를 컨테이너 널어서 관리(Bean 등록)
            - 기본적으로 메소드 이름으로 Bean이 등록된다.
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);//스프링 컨테이너에서 타입이 'MemberService', 이름이 'memberService'인 Bean 꺼내기

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());

    }
}
