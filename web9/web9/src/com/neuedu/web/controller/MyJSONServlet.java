package com.neuedu.web.controller;

import com.alibaba.fastjson.JSON;
import com.neuedu.web.domain.City;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/json")
public class MyJSONServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //javaObject ----jsonString  给到页面
        System.out.println("into jsonservlet de service.........");
        List<City> cities=new ArrayList<>();
        for (int i = 0; i <6 ; i++) {
            City c=new City();
            c.setId(i);
            c.setName("城市"+i);
            cities.add(c);
        }

        //cities--jsonString
        String result=JSON.toJSONString(cities);

        //响应回客户端
        resp.setContentType("text/plain;charset=utf-8");
        resp.getWriter().println(result);

    }
}
