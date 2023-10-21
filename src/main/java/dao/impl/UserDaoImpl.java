package dao.impl;

import beans.User;
import dao.UserDao;
//import dbutils.DBHelper;
import dbutils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

    public int add(User user) {
        //获取数据库连接
//        Connection connection = DBHelper.getConn();
//        Connection connection = DruidUtils.getConn();
//        PreparedStatement pstmt = null;
//        //获取执行SQL语句
//        try {
//            String sql = "insert into user (uname,phone,password,address,balance) values (?,?,?,?,?)";
//            pstmt = connection.prepareStatement(sql);
//            //设置参数
//            pstmt.setString(1, user.getName());
//            pstmt.setString(2, user.getPhone());
//            pstmt.setString(3, user.getPassword());
//            pstmt.setString(4, user.getAddress());
//            pstmt.setDouble(5, user.getBalance());
//            //执行
//            int row = pstmt.executeUpdate();
//            return row;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
////            DBHelper.closeAll(connection, pstmt, null);
//            DruidUtils.closeAll(connection, pstmt, null);
//        }
        String sql = "insert into user (email,phone,pwd,uname) values (?,?,?,?)";
        Object[] params = {user.getEmail(),user.getPhone(),user.getPwd(),user.getUname()};
        try {
            int update = queryRunner.update(sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //用关键字查找
    public User findByStr(String str) {
        //获取数据库连接
//        Connection connection = DBHelper.getConn();
//        Connection connection = DruidUtils.getConn();
//        PreparedStatement pstmt = null;
//        //获取执行SQL语句
//        try {
//            String sql = "iSELECT * FROM USER WHERE uname = ? OR phone = ?";
//            pstmt = connection.prepareStatement(sql);
//            //设置参数
//            pstmt.setString(1, str);
//            pstmt.setString(2, str);
//            //执行
//            ResultSet rs = pstmt.executeQuery();
//            User user = null;
//            if (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("uname");
//                String phone = rs.getString("phone");
//                String password = rs.getString("password");
//                String address = rs.getString("address");
//                double balance = rs.getDouble("balance");
//                user = new User(id, name, phone, password, address, balance);
//            }
//            return user;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
////            DBHelper.closeAll(connection, pstmt, null);
//            DBHelper.closeAll(connection, pstmt, null);
//        }
        String sql = "SELECT * FROM USER WHERE email = ? OR phone = ?";
        Object[] params = {str, str}; // 假设str是email或phone的实际值
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //查找所有
    public List<User> findAll() {
        String sql = "select * from user";
        try {
            List<User> userList = queryRunner.query(sql, new BeanListHandler<User>(User.class));
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //id查找
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        Object[] params = {id};
        try {
            User user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //更新
    public int update(User user) {
        String sql = "update user set email=?,phone=?,pwd=?,uname=? where id=? ";
        Object[] params = {user.getEmail(),user.getPhone(),user.getPwd(),user.getUname(),user.getId()};
        try {
            int update = queryRunner.update(sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //删除
    public int del(int id) {
        String sql = "delete from user where id = ?";
        Object[] params = {id};
        try {
            int update = queryRunner.update(sql, params);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
