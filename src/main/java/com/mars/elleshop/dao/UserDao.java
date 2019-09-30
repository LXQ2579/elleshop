package com.mars.elleshop.dao;

import com.mars.elleshop.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author liujiulong
 * @date 2019/09/29  20:55:00
 */
@Repository
public interface UserDao {

    User findByPhone(String phone);

    void addUser(User user);

}
