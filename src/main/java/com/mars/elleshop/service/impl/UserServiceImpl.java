package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.UserDao;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
import com.mars.elleshop.utils.ImgUtils;
import com.mars.elleshop.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

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
        if (user == null) {
            throw new RuntimeException("手机号错误");
        }
        String passwordMD5 = MD5Utils.md5(password + "liujiulong");
        System.out.println(passwordMD5);
        System.out.println(user.getPassword());
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

        //自动生成名字（中文）
        String ret = "";
        for (int i = 0; i < 5; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret += str;
        }

        newUser.setUsername(ret);

        try {
            newUser.setPhotoUrl(ImgUtils.createBase64Avatar(ret));
        } catch (IOException e) {
            throw new RuntimeException("用户头像生成失败");
        }


        userDao.addUser(newUser);
    }
}
