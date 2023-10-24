<%@ page import="beans.Fruit" %>
<%@ page import="beans.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天果园-水果网购首选品牌，水果，我们只挑有来头的！</title>
    <link rel="stylesheet" type="text/css" href="css/sel.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script src="js/sel.js"></script>
    <jsp:include page="/FruitServlet?key=hot"></jsp:include>
    <jsp:include page="head/head.jsp"></jsp:include>
  <%
    List<Fruit> hotFruits=(List<Fruit>)request.getAttribute("fruits");
    List<Fruit> selFruits=null;
    User user=new User(0);
    if(session.getAttribute("user")!=null)
      user=(User)session.getAttribute("user");
    if(request.getAttribute("selFruits")!=null)
      selFruits=(List<Fruit>)request.getAttribute("selFruits");
  %>
</head>
<body style="position: relative;">
  <div class="fruit_info">
    <div class="fruit_hot" >
      <div class="hf_title"><span class="ht_l">热卖商品</span><span class="ht_r"><a href="">MORE+</a></span></div>

      <%
        int i=1;
        for(Fruit fruits:hotFruits)
        {
          out.print("    <div class=\"hot_fruit\">\n" +
                  "      <div class=\"hf_img\"><a href=\""+request.getContextPath()+"/FruitServlet?key=info&id="+user.getId()+"&fid="+fruits.getFid()+"\"><img src=\"img/fruits/"+fruits.getFid()+"/(1).jpg\" /></a></div>\n" +
                  "      <div c=\"hf_text\">\n" +
                  "        <div class=\"hf_name\"><a href=\""+request.getContextPath()+"/FruitServlet?key=info&id="+user.getId()+"&fid="+fruits.getFid()+"\">"+fruits.getFname()+"</a></div>\n" +
                  "        <div class=\"hf_mon\">￥<span>"+fruits.getUp()+"</span></div>\n" +
                  "      </div>\n" +
                  "    </div>");
          i++;
          if(i==6)
            break;
        }

      %>
    </div>

    <div class="sel">
      <div class="selfruits">
        <ul class="selfruits_ul">
          <li class="selfruits_li">
            价格：
            <a href="<%=request.getContextPath()%>/searchServlet?key=all" class="selkey sgreen">不限</a>
            <a href="<%=request.getContextPath()%>/searchServlet?key=money&selkey=a" class="selkey sgreen">100以下</a>
            <a href="<%=request.getContextPath()%>/searchServlet?key=money&selkey=b" class="selkey sgreen">100~300</a>
            <a href="<%=request.getContextPath()%>/searchServlet?key=money&selkey=c" class="selkey sgreen">300以上</a>
          </li>
        </ul>

      </div>


      <div class="fruitboxs">
        <%
          if (selFruits!=null)
          {
            for(Fruit fruit:selFruits)
            {
              out.print("        <div class=\"fruit_box\">\n" +
                      "          <div class=\"fruit_img\">\n" +
                      "            <a href=\""+request.getContextPath()+"/FruitServlet?key=info&id="+ user.getId()+"&fid="+fruit.getFid()+"\"><img src=\"img/fruits/"+fruit.getFid()+"/(1).jpg\" /></a>\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_name\">\n" +
                      "            <a href=\""+request.getContextPath()+"/FruitServlet?key=info&id="+ user.getId()+"&fid="+fruit.getFid()+"\">"+fruit.getFname()+"</a>\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_spec\">\n" +
                      "            "+fruit.getSpec()+"\n" +
                      "          </div>\n" +
                      "          <div class=\"fruit_up\">\n" +
                      "            ￥"+fruit.getUp()+"\n" +
                      "          </div>\n" +
                      "          <div class=\"flogo\">\n" +
                      "            <img src=\"img/flogo.png\"/>\n" +
                      "          </div>\n" +
                      "        </div>");
            }
          }
        %>

      </div>

      </div>
  </div>

</body>
</html>
