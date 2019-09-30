package com.mars.elleshop.service;

import com.mars.elleshop.entity.User;

/**
 * @author liujiulong
 * @date 2019/09/29  21:05:00
 */
public interface UserService {

    User login(String phone, String password);

    void register(String phone, String password);
}
