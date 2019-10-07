package com.mars.elleshop.service;

import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.entity.Order;
import com.mars.elleshop.entity.PaymentType;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/09/29  21:05:00
 */
public interface OrderService {


    List<Order> findAllOrders(String phone, String address, String idInformation);

    void saveOrders(Order order);

    List<Coupons> showCoupons();

    Coupons chooseCoupons(Integer couponsId);

    List<PaymentType> showPaymentType();

    PaymentType choosePaymentType(Integer paymentTypeId);


}
