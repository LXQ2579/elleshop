package com.mars.elleshop.controller;

import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {
   @Autowired
    private OrderService orderService;


    @RequestMapping("/checkout")
    public String checkout(HttpSession session, Integer aid){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getUid();
        int checkout = orderService.checkout(uid, aid);
        System.out.println(checkout);
        return null;
    }



}
