package com.mars.elleshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author liujiulong
 * @date 2019/09/27  15:16:00
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping("/login.do")
//    public String login(String phone, String password , HttpSession session){
//
//        User user = userService.login(phone, password);
//        session.setAttribute(StrUtils.LOGIN_INFO, user);
//
//        return "redirect:/secKill/list.do";
//    }
//
//    @RequestMapping("/tologin")
//    public String toLogin(){
//        return "login";
//    }
}
