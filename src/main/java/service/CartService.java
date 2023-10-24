package service;

import beans.Cart;

public interface CartService {

    //添加购物车或者关注
    public boolean add(int uid, Cart cart);

    //查询是否存在
    public Cart find(int uid,int fid);
}
