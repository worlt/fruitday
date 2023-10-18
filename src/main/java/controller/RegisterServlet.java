package controller;

import beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    //获取参数
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String pwd1 = request.getParameter("pwd1");

        //封装实体类
        User user = new User(username,phone,pwd1);

        //调用业务逻辑实现

        //根据结果响应

    }



}
