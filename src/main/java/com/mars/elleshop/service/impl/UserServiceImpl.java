package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.UserDao;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
import com.mars.elleshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liujiulong
 * @date 2019/09/29  21:05:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String phone, String password) {

        User user = userDao.findByPhone(phone);
        if (user == null){
            throw new RuntimeException("手机号错误");
        }
        String passwordMD5 = MD5Utils.md5(password + "liujiulong");
        System.out.println(passwordMD5);
        System.out.println(user.getPassword());
        if (!passwordMD5.equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void register(String phone, String password) {
        if (phone ==null || "".equals(phone)){
            throw new RuntimeException("手机号不能为空");
        }
        if (password ==null || "".equals(password)){
            throw new RuntimeException("密码不能为空");
        }
        User user = userDao.findByPhone(phone);
        if (user != null){
            throw new RuntimeException("手机号已被注册");
        }
        String passwordMD5 = MD5Utils.md5(password + "liujiulong");
        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setPassword(passwordMD5);

        userDao.addUser(newUser);
    }
}
