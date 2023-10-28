package controller;


import beans.Fruit;
import beans.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.FruitService;
import service.FruitServiceImpl;
import service.UserService;
import service.UserServiceImpl;


import java.util.List;

//后台管理
@WebServlet("/BSServlet")
public class BSServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private FruitService fruitService = new FruitServiceImpl();
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

    //删除用户
    public String deluser(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String uidStr = request.getParameter("id");
        int uid = Integer.parseInt(uidStr);
        //调用业务逻辑层
        boolean del = userService.del(uid);
        if (del) {
            //添加成功
            return alluser(request,response);
        }
        //添加失败
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

    //展示水果列表
    public String allfruit(HttpServletRequest request, HttpServletResponse response){
        //调用业务逻辑
        List<Fruit> all = fruitService.findAll();
        request.setAttribute("allfruit",all);
        return "forward:/BSindex4.jsp";
    }

    //添加商品
    public String addfruit(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String fid1Str = request.getParameter("fid1");
        String fname1 = request.getParameter("fname1");
        String spec1 = request.getParameter("spec1");
        String up1Str = request.getParameter("up1");
        String t1 = request.getParameter("t11");
        String t2 = request.getParameter("t21");
        String inum1Str = request.getParameter("inum1");
        int fid = Integer.parseInt(fid1Str);
        double up1 = Double.parseDouble(up1Str);
        int inum1 = Integer.parseInt(inum1Str);
        Fruit fruit = new Fruit(fid,fname1,spec1,up1,t1,t2,inum1);
        //调用业务逻辑
        boolean addFruit = fruitService.add(fruit);
        if (addFruit) {
            //添加成功
            return allfruit(request,response);
        }
            //添加失败
            return null;
    }

    //删除用户
    public String delfruit(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        //调用业务逻辑层
        boolean del = fruitService.del(fid);
        if (del) {
            //添加成功
            return allfruit(request,response);
        }
        //添加失败
        return null;

    }


    //根据fid来查询商品
    public String findfruit(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        //调用业务逻辑
        Fruit fruit = fruitService.findById(fid);
        request.setAttribute("fruit",fruit);
        return "forward:/BSindex6.jsp";
    }


    //更新商品
    public String upfruit(HttpServletRequest request, HttpServletResponse response){
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname2 = request.getParameter("fname2");
        String spec2 = request.getParameter("spec2");
        String up2Str = request.getParameter("up2");
        String t12 = request.getParameter("t12");
        String t22 = request.getParameter("t22");
        String inum2Str = request.getParameter("inum2");
        double up2 = Double.parseDouble(up2Str);
        int inum2 = Integer.parseInt(inum2Str);

        Fruit fruit = new Fruit(fid, fname2,spec2,up2,t12,t22,inum2); //添加fid参数
        boolean update = fruitService.update(fruit);
        if (update){
            return "redirect:/BSServlet?key=allfruit"; //使用重定向
        }
        return  null;
    }




}
