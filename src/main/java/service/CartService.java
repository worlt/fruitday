package service;

import beans.Cart;
import beans.Fruit;

import java.util.List;

public interface CartService {

    //添加购物车或者关注
    public boolean add(int uid, Cart cart);

    //查询是否存在
    public Cart find(int uid,int fid);

    //更新
    public boolean update(int uid, Cart cart);

    //删除
    public boolean del(int uid,int fid);

    //根据uid查询购物车列表或者关注列表
    public List<Cart> findByUid(int uid);

    //显示列表根据boolean值来确定显示购物车列表还是关注列表
    public List<Fruit> show(int uid, boolean flag);

    //根据uid查询购物车列表
    public List<Cart> findCartByUid(int uid);

}
