package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.UserService;
import com.mars.elleshop.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;
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

    @PostMapping("/login.do")
    @ApiOperation(value="用于用户登陆验证", notes="获取用户手机号和密码用于登陆，密码和验证码只需要其中一个")
    public JsonBean<String> login(@ApiParam(value = "用户手机号")String phone,@ApiParam(value = "用户密码") String password, @ApiParam(value = "验证码")String code){

        if (code != null){
            return new JsonBean<>(1, "暂不支持短信登陆");
        }

        userService.login(phone, password);

        //盐值
        //生成token
        String token = MD5Utils.md5(phone + "liujiulong");
        //将token放入到redis中
        stringRedisTemplate.opsForValue().set(token, phone);
        stringRedisTemplate.expire(token,24, TimeUnit.HOURS);
        return new JsonBean<>(0, token);
    }



    @ApiOperation(value="注册用户信息", notes="获取用户手机号和密码用于注册")
    @PostMapping("/register.do")
    public JsonBean<String> userRegister(@ApiParam(value = "用户手机号")String phone, @ApiParam(value = "用户密码")String password, @ApiParam(value = "验证码")String code){

        userService.checkMessage(phone, code);
        userService.register(phone, password);

        return new JsonBean<>(0, "注册成功");
    }

    @ApiOperation(value="获取用户信息", notes="获取用户手机号和密码用于注册")
    @PostMapping("/message.do")
    public JsonBean<User> message(@ApiParam(value = "请求头数据，不需要传值") HttpServletRequest request) {

        String token = request.getHeader("token");
        //将token放入到redis中
        String phone = stringRedisTemplate.opsForValue().get(token);
        User user = userService.showUserMessage(phone);

        return new JsonBean<User>(0, user);
    }


    @ApiOperation(value="发送短信验证码", notes="向用户手机号发送短信验证码")
    @PostMapping("/sendCode.do")
    public JsonBean<String> sendCode(String phone) {

        String str = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str += (random.nextInt(10));
        }
        userService.sendMessage(phone, str);
        String code = MD5Utils.md5(phone + "sendCode");
        //将token放入到redis中
        stringRedisTemplate.opsForValue().set(code, str);
        stringRedisTemplate.expire(code,300, TimeUnit.SECONDS);

        return new JsonBean<>(0, "短信发送, 请在五分钟之内完成验证");
    }


}
