package controller;

import beans.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        //获取参数
        String key = request.getParameter("key");
        //根据标识做不同的处理
        if (key.equals("login")){
            //登录
            login(request,response);
        }else if (key.equals("register")){
            //注册
            register(request,response);
        }
    }


    //登录
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String str = request.getParameter("str");
        String pwd = request.getParameter("pwd");

        //调用业务逻辑实现
        User loginUser = userService.login(str, pwd);
        if (loginUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
            //跳回首页
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            //注册页面不变
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }


    //注册
    protected void register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
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
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }else {
            //注册页面不变
            request.getRequestDispatcher("/rej.jsp").forward(request,response);
        }
    }
}
