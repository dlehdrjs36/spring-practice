package com.devhistory.springcoreprinciple.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void prototypeBeanFind() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("find prototypeBean1");//프로토타입 빈 조회 직전 생성
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");//프로토타입 빈 조회 직전 생성
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        ac.close(); // 프로토타입의 소멸은 컨테이너가 관리하지않아서 destroy가 호출되지 않는다.
        prototypeBean1.destroy(); //프로토타입 빈은 클라이언트가 직접 관리해야한다. 필요하다면 직접 종료 메소드 호출.
        prototypeBean2.destroy(); //프로토타입 빈은 클라이언트가 직접 관리해야한다. 필요하다면 직접 종료 메소드 호출.
    }

    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}
