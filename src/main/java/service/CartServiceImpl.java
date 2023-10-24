package service;

import beans.Cart;
import dao.CartDao;
import dao.impl.CartDaoImpl;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();

    //添加关注
    public boolean add(int uid, Cart cart) {
        int add = cartDao.add(uid, cart);
        if (add == 1) {
            return true;
        }
        return false;
    }

    //查询是否存在
    public Cart find(int uid, int fid) {
        return cartDao.find(uid,fid);
    }
}
