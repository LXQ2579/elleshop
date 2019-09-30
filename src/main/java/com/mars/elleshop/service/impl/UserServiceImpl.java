package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.UserDao;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
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
        if (!password.equals(user.getPassword())){
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void register(String phone, String password) {
        User user = new User();
        user.setPhone(phone);
        user.setPassword(password);

        userDao.addUser(user);

    }
}
