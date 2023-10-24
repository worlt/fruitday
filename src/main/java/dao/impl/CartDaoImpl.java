package dao.impl;

import beans.Cart;
import dao.CartDao;
import dbutils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class CartDaoImpl implements CartDao {
    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    public int add(int uid, Cart cart) {
        String sql = "INSERT INTO shop(uid,fid,isStar,isCart) VALUES (?,?,?,?);";
        Object[] params = {uid,cart.getFid(),cart.isStar(),cart.isCart()};
        try {
            int add = queryRunner.update(sql, params);
            return add;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public int update(int uid, Cart cart) {
        return 0;
    }

    public int del(int uid, Cart cart) {
        return 0;
    }

    public Cart find(int uid, int fid) {
        String sql  ="SELECT * FROM shop WHERE uid = ? AND fid = ?;";
        Object[] params = {uid,fid};
        try {
            Cart cart = queryRunner.query(sql, new BeanHandler<Cart>(Cart.class), params);
            return cart;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
