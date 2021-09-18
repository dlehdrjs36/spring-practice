package com.devhistory.springcoreprinciple.servlet.basic.response;

import com.devhistory.springcoreprinciple.servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Content-Type: application/json
        response.setContentType("application/json");
        //response.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUsername("lee");
        helloData.setAge(20);

        //Json 형태로 변환
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);
    }
}
