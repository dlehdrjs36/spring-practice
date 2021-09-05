package com.devhistory.springcoreprinciple.web;

import com.devhistory.springcoreprinciple.common.MyLogger;
import com.devhistory.springcoreprinciple.common.MyProxyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProxyLogDemoService {

    private final MyProxyLogger myProxyLogger;

    public void logic(String id) {
        myProxyLogger.log("service id = " + id);
    }
}
