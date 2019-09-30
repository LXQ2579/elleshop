package com.mars.elleshop.dao;

import com.mars.elleshop.entity.User;

/**
 * @author liujiulong
 * @date 2019/09/29  20:55:00
 */
public interface UserDao {

    User findByPhone(String phone);

    void addUser(User user);

}
