package controller;

import beans.Cart;
import service.CartService;
import service.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet{
    private CartService cartService = new CartServiceImpl();

    //添加购物车或者关注列表
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String uidStr = request.getParameter("id");
        String fidStr = request.getParameter("fid");
        String str = request.getParameter("str");
        int uid= Integer.parseInt(uidStr);
        int fid = Integer.parseInt(fidStr);
        if (uid != 0){//用户已登录
            Cart cart = cartService.find(uid,fid);
            if (cart==null){//不存在购物车
                cart = new Cart();
                cart.setUid(uid);
                cart.setFid(fid);
                if ("cart".equals(str)){
                    cart.setIsCart(true);
                    cart.setIsStar(false);
                }else if ("star".equals(str)){
                    cart.setIsCart(false);
                    cart.setIsStar(true);
                }
                cartService.add(uid,cart);
            }
            //跳到详情页面
            return "forward:/FruitServlet?key=info&id="+uid+"&fid="+fid;
        }else {//没有登录
            //转发到登录页面
            request.setAttribute("showError", true);
            return "forward:/login.jsp";
        }
        //调用业务逻辑
    }
}
