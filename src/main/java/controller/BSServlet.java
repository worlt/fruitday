package controller;


import beans.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

//后台管理
@WebServlet("/BSServlet")
public class BSServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    //跳转到后台首页
    public String toAdmin(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return "redirect:/BSindex.jsp";
        }
        //转发到登录页面
        request.setAttribute("showError", true);
        return "forward:/login.jsp";
    }


    //展示用户列表
    public String alluser(HttpServletRequest request, HttpServletResponse response) {
        //调用业务逻辑层
        List<User> all = userService.findAll();
        request.setAttribute("allusers", all);
        return "forward:/BSindex1.jsp";
    }

    //添加用户
    public String adduser(HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String name1 = request.getParameter("name1");
        String email1 = request.getParameter("email1");
        String phone1 = request.getParameter("phone1");
        String pwd1 = request.getParameter("pwd1");
        User user = new User(name1, email1, phone1, pwd1);
        //调用业务逻辑层
        User addUser = userService.add(user);
        if (addUser != null) {
            return alluser(request, response);
        }
        return null;
    }


    //根据uid查询用户
    public String finduser(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String uidStr = request.getParameter("id");
        int uid = Integer.parseInt(uidStr);
        //调用业务逻辑层
        User user = userService.findById(uid);
        request.setAttribute("user",user);
        return "forward:/BSindex3.jsp";
    }

    //更新用户
    public String upuser(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String name2 = request.getParameter("name2");
        String email2 = request.getParameter("email2");
        String phone2 = request.getParameter("phone2");
        String pwd2 = request.getParameter("pwd2");

        String uidStr = request.getParameter("id");
        int uid = Integer.parseInt(uidStr);
        User user = new User(uid, email2, phone2, pwd2, name2);
        boolean update = userService.update(user);
        if (update){
            return alluser(request,response);
        }
        return null;

    }


}
