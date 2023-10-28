package controller;

import beans.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UserService;
import service.UserServiceImpl;


import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //登录
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String str = request.getParameter("str");
        String pwd = request.getParameter("pwd");

        //调用业务逻辑实现
        User loginUser = userService.login(str, pwd);
        if (loginUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
            //跳回首页
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return "redirect:/index.jsp";
        } else {
            //注册页面不变
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return "redirect:/login.jsp";
        }
    }


    //注册
    public String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //获取参数
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pwd1 = request.getParameter("pwd1");

        //封装实体类
        User user = new User(email,phone,pwd1,email);

        //调用业务逻辑实现
        User loginUser = userService.add(user);
        if (loginUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user",loginUser);
            //跳回首页
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return "redirect:/index.jsp";

        }else {
            //注册页面不变
//            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return "forward:/login.jsp";
        }
    }
}
