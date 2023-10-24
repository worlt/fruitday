package dao;

import beans.Cart;

public interface CartDao {


    //添加购物车
    public int add(int uid, Cart cart);

    //
    public int update(int uid,Cart cart);

    //
    public int del(int uid,Cart cart);

    //查询是否已存在
    public Cart find(int uid,int fid);




}
