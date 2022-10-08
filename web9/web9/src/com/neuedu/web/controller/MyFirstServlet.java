package com.neuedu.web.controller;

import com.neuedu.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 第一个servlet
 * 1.继承HttpServlet
 * 2.重写service方法
 * 3.如果servlet的开发比较苛刻，严格区分get请求和post请求，那么重写doGet方法  或者doPost方法
 * 4.在重写的方法中  ①获取客户端信息  ②对信息进行处理   ③对信息进行响应
 *   本案例模拟一个登录的需求： username password
 */
@WebServlet("/first")
public class MyFirstServlet extends HttpServlet {
    @Override  //service方法通吃：get方式递交的请求 post方式递交的请求 service都能处理
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取客户端信息   请求参数   客户端的其他信息：比如设备 客户端的ip地址
        String username=req.getParameter("username");// baidu.com?wd=北溪二号
        String password=req.getParameter("password");

        System.out.println(username+","+password);

        String url=req.getRequestURL().toString();
        String uri=req.getRequestURI();
        String host=req.getRemoteHost();

        System.out.println(url+","+uri+","+host);

        String userAgent=req.getHeader("user-agent");

        if(userAgent.indexOf("iPhone")!=-1){
            System.out.println("是苹果手机");
        }
        if(userAgent.indexOf("Android")!=-1){
            System.out.println("是安卓手机");
        }
        if(userAgent.indexOf("Windows")!=-1){
            System.out.println("pc端");
        }

        System.out.println("------------------------------");
        //如何处理数据呢？调用service处理即可
        UserService userService=new UserService();
        boolean result=userService.login(username,password);

        //如何响应呢？响应一个纯文本：登录成功 或者登录失败
        resp.setContentType("text/plain;charset=utf-8");
        PrintWriter pw=resp.getWriter();
        if(result){
            pw.println("<h1>登录成功</h1>");

        }else{
            pw.println("<h1>登录失败</h1>");

        }

    }
}
