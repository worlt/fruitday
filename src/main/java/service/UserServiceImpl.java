package service;

import beans.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    public User add(User user) {
        int add = userDao.add(user);
        if (add == 1){
            User loginUser = login(user.getName(), user.getPassword());
            return loginUser;
        }
        return null;
    }

    public User login(String str, String pwd) {
        User user = userDao.findByStr(str);
        if (user.getPassword().equals(str)){
            user.setPassword("******");
            return user;
        }
        return null;
    }
}
