package test;

import beans.User;
import dao.impl.UserDaoImpl;

public class test1 {
    public static void main(String[] args) {
        UserDaoImpl userDao = new  UserDaoImpl();
        User user= new User();
        user.setUname("aaa");
        user.setPwd("123");
        userDao.add(user);

    }

}
