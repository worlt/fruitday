package service;

import beans.Cart;
import beans.Fruit;
import dao.CartDao;
import dao.FruitDao;
import dao.impl.CartDaoImpl;
import dao.impl.FruitDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CartDaoImpl();
    private FruitDao fruitDao = new FruitDaoImpl();
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
        return cartDao.find(uid, fid);
    }


    //更新
    public boolean update(int uid, Cart cart) {
        int update = cartDao.update(uid, cart);
        if (update == 1) {
            return true;
        }
        return false;
    }

    ///删除
    public boolean del(int uid, int fid) {
        int del = cartDao.del(uid,fid);
        if (del==1){
            return true;
        }
        return false;
    }


    //根据uid查询购物车列表或者关注列表
    public List<Cart> findByUid(int uid){
        return cartDao.findByUid(uid);
    }

    //根据uid查询购物车列表
    public List<Cart> findCartByUid(int uid){
        return cartDao.findCartByUid(uid);
    }


    //显示列表根据boolean值来确定显示购物车列表还是关注列表
    public List<Fruit> show(int uid,boolean flag){
        List<Cart> carts = findByUid(uid);
        List<Fruit> fruits = new ArrayList<Fruit>();
        if (flag){//那么返回购物车列表
            for (Cart cart : carts) {
                if (cart.isCart()){
                    Fruit fruit = fruitDao.findById(cart.getFid());
                    fruits.add(fruit);
                }
            }
        }else {//返回我的关注列表
            for (Cart cart : carts) {
                if (cart.isStar()){
                    Fruit fruit = fruitDao.findById(cart.getFid());
                    fruits.add(fruit);
                }
            }
        }
        return fruits;
    }
}
