package service;

import beans.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    public User add (User user) {
        int add = userDao.add(user);
        if (add == 1) {
            User loginUser = login(user.getEmail(), user.getPwd());
            return loginUser;
        } else {
            return null;
        }
    }

    public User login(String str, String pwd) {
        User user = userDao.findByStr(str);
        if (user.getPwd().equals(pwd)) {
            user.setPwd("******");
            return user;
        } else {
            return null;
        }
    }
}
