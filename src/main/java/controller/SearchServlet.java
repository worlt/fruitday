package controller;

import beans.Fruit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.FruitService;
import service.FruitServiceImpl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/searchServlet")
public class SearchServlet extends BaseServlet {

    private FruitService fruitService = new FruitServiceImpl();

    //根据关键字搜索商品
    public String search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String selkey = request.getParameter("selkey");

        if (selkey == null || selkey.equals("") || selkey.equals("all")) {
            // 搜索所有商品
            List<Fruit> all = fruitService.findAll();
            request.setAttribute("selFruits", all);
            return "forward:/search.jsp";

        } else {
            List<Fruit> fruits = fruitService.findByStr(selkey);
            request.setAttribute("selFruits", fruits);
            return "forward:/search.jsp";

        }

    }

    //搜索所有商品
    public String all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        List<Fruit> all = fruitService.findAll();
        request.setAttribute("selFruits", all);

        return "forward:/search.jsp";
    }


    //根据价格搜索
    public String money(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //获取参数
        String key = request.getParameter("selkey");
        int start = 0;
        int end = 0;
        if ("a".equals(key)){
            start = 0;
            end = 100;
        }else if ("b".equals(key)){
            start = 100;
            end = 300;
        }else if ("c".equals(key)){
            start = 300;
            end = 999999;
        }
        //查询所有的水果
        List<Fruit> all = fruitService.findAll();
        List<Fruit> resultList = new ArrayList<Fruit>();
        for (Fruit fruit : all){
            if  (fruit.getUp() >= start && fruit.getUp() < end){
                resultList.add(fruit);
            }
        }
        request.setAttribute("selFruits",resultList);
        return "forward:/search.jsp";
    }


}


