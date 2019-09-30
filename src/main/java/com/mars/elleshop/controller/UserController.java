package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
import com.mars.elleshop.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author liujiulong
 * @date 2019/09/27  15:16:00
 */
@Api("用户管理API")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/login.do")
    public JsonBean login(String phone, String password){

        //盐值
        //生成token

        String passwordMD5 = MD5Utils.md5(password + "liuxiaoqi");
        User user = userService.login(phone, passwordMD5);

        String token = MD5Utils.md5(phone + "liujiulong");
        //将token放入到redis中
        stringRedisTemplate.opsForValue().set(token, phone);
        stringRedisTemplate.expire(token,1800, TimeUnit.SECONDS);
        return new JsonBean<>(1, "登录成功");
    }


    @ApiOperation(value="获取用户信息", notes="获取用户手机号和密码用于注册")
    @RequestMapping("/register.do")
    public JsonBean userRegister(String phone, String password) {

        userService.register(phone, password);

        return new JsonBean<>(1, "注册成功");
    }
}
