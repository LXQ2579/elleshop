package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.service.UserCouponsService;
import com.mars.elleshop.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sanriyue
 */
@Api("用户的优惠券相关模块")
@RestController
@RequestMapping(path = "/userCoupons")
public class UserCouponsController {
    @Autowired
    private UserCouponsService userCouponsService;

    @ApiOperation(value = "所有的优惠券,返回的是一个LIST ")
    @GetMapping("/allCoupons.do")
    public JsonBean<List<Coupons>> allCoupons(){
        List<Coupons> allCoupons = userCouponsService.findAllCoupons();
        return new JsonBean<>(0,allCoupons);
    }

    @ApiOperation(value = "给用户添加优惠券,必须登录状态，且请求头有token")
    @GetMapping("/allCoupons.do")
    public JsonBean<String> addCoupons(Integer couponsId, HttpServletRequest request){
        String token = request.getHeader("token");
        userCouponsService.addCoupons(couponsId,token);
        return new JsonBean<>(0,"优惠券已添加");
    }
}
