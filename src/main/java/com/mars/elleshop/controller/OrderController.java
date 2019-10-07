package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.entity.Order;
import com.mars.elleshop.entity.PaymentType;
import com.mars.elleshop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api("订单管理API")
@RestController
@RequestMapping(path = "/order")
public class OrderController {

   @Autowired
    private OrderService orderService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/showOrder.do")
    @ApiOperation(value="用于结算页面显示", notes="展示用户信息, 用户所选购物车物品信息, 选中优惠劵信息, 清关信息, 支付方式, 小计合计等")
    public JsonBean<List<Order>> showOrder(HttpServletRequest request,@ApiParam(value = "用户手机号")String phone, @ApiParam(value = "用户地址") String address, @ApiParam(value = "用户清关信息")String idInformation){
//        String token = request.getHeader("token");
//        String phone = stringRedisTemplate.opsForValue().get(token);
        List<Order> orders = orderService.findAllOrders(phone, address, idInformation);

        return new JsonBean<>(0, orders);
    }



    @PostMapping("/showCoupons.do")
    @ApiOperation(value="展示所有可用优惠劵", notes="展示所有可用优惠劵信息")
    public JsonBean<List<Coupons>> showCoupons(){

        List<Coupons> coupons = orderService.showCoupons();

        return new JsonBean<>(0, coupons);
    }

    @PostMapping("/chooseCoupon.do")
    @ApiOperation(value="选择优惠劵", notes="选择优惠劵")
    public JsonBean<String> chooseCoupon(@ApiParam(value = "所选择的优惠劵id") Integer couponId){

        orderService.chooseCoupons(couponId);

        return new JsonBean<>(0, "选择优惠劵成功");
    }


    @PostMapping("/showPaymentType.do")
    @ApiOperation(value="展示所有可选支付方式", notes="展示所有可选支付方式信息")
    public JsonBean<List<PaymentType>> showPaymentType(){

        List<PaymentType> paymentTypes = orderService.showPaymentType();

        return new JsonBean<>(0, paymentTypes);
    }

    @PostMapping("/choosePaymentType.do")
    @ApiOperation(value="选择支付方式", notes="选择支付方式")
    public JsonBean<String> choosePaymentType(@ApiParam(value = "所选择的支付方式的id") Integer paymentTypeId){

        orderService.choosePaymentType(paymentTypeId);

        return new JsonBean<>(0, "选择支付方式成功");
    }





}
