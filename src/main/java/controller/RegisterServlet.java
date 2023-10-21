//package controller;
//
//import beans.User;
//import service.UserService;
//import service.UserServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebServlet("/registerServlet")
//public class RegisterServlet extends HttpServlet {
//    private UserService userService = new UserServiceImpl();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//        doPost(request,response);
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
//        //获取参数
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String pwd1 = request.getParameter("pwd1");
//
//        //封装实体类
//        User user = new User(email,phone,pwd1,email);
//
//        //调用业务逻辑实现
//        User loginUser = userService.add(user);
//        if (loginUser != null){
//            HttpSession session = request.getSession();
//            session.setAttribute("user",loginUser);
//            //跳回首页
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
//        }else {
//            //注册页面不变
//            request.getRequestDispatcher("/rej.jsp").forward(request,response);
//        }
//    }
//}
