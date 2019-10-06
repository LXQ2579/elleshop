package com.mars.elleshop.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.mars.elleshop.dao.UserDao;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
import com.mars.elleshop.utils.ImgUtils;
import com.mars.elleshop.utils.MD5Utils;
import com.mars.elleshop.utils.MessageUtils;
import com.mars.elleshop.utils.NameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author liujiulong
 * @date 2019/09/29  21:05:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public User login(String phone, String password) {
        if (phone == null || "".equals(phone)) {
            throw new RuntimeException("手机号不能为空");
        }
        User user = userDao.findByPhone(phone);
        if (user == null) {
            throw new RuntimeException("手机号错误");
        }
        String passwordMD5 = MD5Utils.md5(password + "liujiulong");
        if (!passwordMD5.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void register(String phone, String password) {
        if (phone == null || "".equals(phone)) {
            throw new RuntimeException("手机号不能为空");
        }
        if (password == null || "".equals(password)) {
            throw new RuntimeException("密码不能为空");
        }
        User user = userDao.findByPhone(phone);
        if (user != null) {
            throw new RuntimeException("手机号已被注册");
        }
        String passwordMD5 = MD5Utils.md5(password + "liujiulong");
        User newUser = new User();
        newUser.setPhone(phone);
        newUser.setPassword(passwordMD5);

        String name = NameUtils.creatName();
        newUser.setUsername(name);

        try {
            newUser.setPhotoUrl(ImgUtils.createPhotoImg(name));
        } catch (IOException e) {
            throw new RuntimeException("用户头像生成失败");
        }
        userDao.addUser(newUser);
    }

    @Override
    public User showUserMessage(String phone) {

        User user = userDao.findByPhone(phone);
        return user;
    }

    @Override
    public boolean sendMessage(String phone, String code) {
        if (phone == null || "".equals(phone)) {
            throw new RuntimeException("手机号不能为空");
        }
        User user = userDao.findByPhone(phone);
        if (user != null) {
            throw new RuntimeException("手机号已被注册，暂不支持短信登陆");
        }

        try {
            Boolean bo = MessageUtils.sendMessage(phone, code);
            if (bo) {
                return true;
            }
        } catch (ClientException e) {
            throw new RuntimeException("短信发送失败，请稍后再试");
        }

        return false;
    }

    @Override
    public void checkMessage(String phone, String intoCode) {

        if (phone == null || "".equals(phone)) {
            throw new RuntimeException("手机号不能为空");
        }
        if (intoCode == null || "".equals(intoCode)) {
            throw new RuntimeException("验证码不能为空");
        }

        String code = MD5Utils.md5(phone + "sendCode");
        //将token放入到redis中
        String oldCode = stringRedisTemplate.opsForValue().get(code);
        if (!intoCode.equals(oldCode)) {
            throw new RuntimeException("验证码错误");
        }
    }
}
