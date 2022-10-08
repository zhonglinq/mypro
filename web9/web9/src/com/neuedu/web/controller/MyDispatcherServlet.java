package com.neuedu.web.controller;
//让这个servlet和web应用一起被初始化，属于积极加载

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/dispatcher"},loadOnStartup =1)
/*
loadOnStartup:
负数：不积极加载，懒加载，客户端请求过来才实例化
0：  积极加载，实例化
正数：积极加载，实例化
   1  数字越小，优先级越高，实例化的越快
   2
   3
   ...
 */
public class MyDispatcherServlet extends HttpServlet {

    public MyDispatcherServlet() {
        System.out.println("dispatcherServlet 被实例化了。。。。。。。。。。。。。");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("老大处理事情。。。。。。。。。。。。。。。");
    }
}
