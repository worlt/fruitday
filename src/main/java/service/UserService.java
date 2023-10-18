package service;

import beans.User;

public interface UserService {
    //注册用户
    public User add(User user);

    /*
    根据用户名和密码登录
     */
    public User login(String str,String pwd);




}
