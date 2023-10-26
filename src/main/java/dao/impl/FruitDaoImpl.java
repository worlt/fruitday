package dao.impl;

import beans.Fruit;
import dao.FruitDao;
import dbutils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FruitDaoImpl implements FruitDao {
     private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    // 热卖水果id
    public List<Fruit> findHot() {
        String sql = "select t2.* from hotfruits t1, fruits t2 where t1.fid = t2.fid;";
        try {
            List<Fruit> fruitList = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class));
            return fruitList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 根据id查询水果详情
    public Fruit findById(int fid) {
        String sql = "select * from fruits where fid = ?";
        Object[] params = {fid};
        try {
            Fruit fruit = queryRunner.query(sql, new BeanHandler<Fruit>(Fruit.class), params);
            return fruit;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //根据关键字搜索
    public List<Fruit> findByStr(String keyword) {
        String sql = "SELECT * FROM fruits WHERE fname LIKE ?;";
        Object[] params = {"%" + keyword + "%"};
        try {
            List<Fruit> fruits = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class), params);
            return fruits;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查询所有
    public List<Fruit> findAll() {
        String sql = "select * from fruits;";
        List<Fruit> fruitList = null;
        try {
             fruitList = queryRunner.query(sql, new BeanListHandler<Fruit>(Fruit.class));
             return fruitList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //添加商品
    public int add(Fruit fruit) {
        String sql = "INSERT INTO fruits(fid, fname, spec, up, t1, t2, inum) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {fruit.getFid(),fruit.getFname(),fruit.getSpec(),fruit.getUp(), fruit.getT1(), fruit.getT2(), fruit.getInum()};
        try {
            int add = queryRunner.update(sql,params);
            return add;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //修改商品
    public int update(Fruit fruit) {

        String sql = "UPDATE fruits SET fname = ?,spec = ?,up = ?,t1 = ?,t2 = ?,inum = ? WHERE fid = ?;";
        Object[] params = {fruit.getFname(),fruit.getSpec(),fruit.getUp(), fruit.getT1(), fruit.getT2(), fruit.getInum(),fruit.getFid()};
        try {
            int update = queryRunner.update(sql,params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //删除商品
    public int del(int fid) {
        String sql = "delete from fruits WHERE fid = ?;";
        Object[] params = {fid};
        try {
            int del = queryRunner.update(sql,params);
            return del;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
