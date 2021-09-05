package com.devhistory.springcoreprinciple.web;

import com.devhistory.springcoreprinciple.common.MyLogger;
import com.devhistory.springcoreprinciple.common.MyProxyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class ProxyLogDemoController {

    private final ProxyLogDemoService proxyLogDemoService;
    private final MyProxyLogger myProxyLogger;

    @RequestMapping("proxy-log-demo")
    @ResponseBody
    public String proxylogDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();

        /* 프록시 설정 사용 시, cglib로 조작하여 가짜 객체를 주입시켜줌.(프로바이더처럼 동작)
           가짜 객체는 싱글톤처럼 등록됨.
           실제 호출 시점에 진짜 객체를 찾아서 호출(프로바이더처럼 동작)
           myProxyLogger = class com.devhistory.springcoreprinciple.common.MyProxyLogger$$EnhancerBySpringCGLIB$$3790e9b
         */
        System.out.println("myProxyLogger = " + myProxyLogger.getClass());
        myProxyLogger.setRequestURL(requestURL);

        myProxyLogger.log("controller test");
        Thread.sleep(1000);
        proxyLogDemoService.logic("testId");
        return "OK";
    }

}
