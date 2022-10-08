package com.neuedu.web.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//DispatcherServlet  springMVC框架的老大
@WebServlet(urlPatterns={"/life"},initParams={@WebInitParam(name="encoding",value = "utf-8"),
        @WebInitParam(name="companyName",value = "neuedu")})
public class LifeServlet extends HttpServlet {

    /**1.读取servlet的配置信息
     * 2.加载servlet class文件
     * 3.实例化servlet              只调用一次
     * 4.调用servlet的初始化方法      只调用一次
     * -------------------------
     * 5.调用servlet的service方法    请求多少次，就调用多少次
     * 6.调用doGet或者doPost方法      请求多少次，就调用多少次
     * 7.调用销毁方法                tomcatserver stop时候或者restart时候，调用销毁方法
     */
    public LifeServlet() {
        System.out.println("实例化。。。。。。。。。。。。。。。");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet............");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost.................");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service..................");
            String method=req.getMethod();

            if("Get".equalsIgnoreCase(method)){
                doGet(req,resp);
            }
            if("Post".equalsIgnoreCase(method)){
                doPost(req,resp);
            }
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁了。。。。。。。。。。。。。。。。");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
       //初始化方法意思是可以给servlet传递一些初始化参数
        System.out.println("init ...................");
        String encoding=config.getInitParameter("encoding");
        String companyName=config.getInitParameter("companyName");
        System.out.println(encoding+","+companyName);
    }
}
