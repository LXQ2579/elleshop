package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.*;
import com.mars.elleshop.entity.*;
import com.mars.elleshop.service.OrderService;
import com.mars.elleshop.utils.Constant;
import com.mars.elleshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liujiulong
 * @date 2019/09/29  21:05:00
 */
@Service
public class OrderServiceImpl implements OrderService {

    private Coupons coupon;
    private PaymentType paymentType;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CouponsDao couponsDao;

    @Autowired
    private PaymentTypeDao paymentTypeDao;


    @Override
    public List<Order> findAllOrders(String phone, String address, String idInformation) {
        if (phone == null){
            throw new RuntimeException("登陆失效,请重新登陆");
        }
        User user = userDao.findByPhone(phone);

        List<Object> values = redisTemplate.opsForHash().values(user.getUid()+ Constant.CART_KEY);
        List<ShoppingCart> goodsList = JsonUtils.jsonToList(values.toString(),ShoppingCart.class);
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < goodsList.size(); i++) {
            Order order = new Order();
            order.setUser(user);
            order.setGoodsType(goodsList.get(i).getGoodsType());
            order.setGoodsNum(goodsList.get(i).getGoodsNum());
            order.setAddress(address);
            order.setIdInformation(idInformation);
            order.setPaymentType(paymentType);
            order.setCreateTime(new Date());
            order.setPrice(goodsList.get(i).getGoodsType().getPrice() * goodsList.get(i).getGoodsNum() - coupon.getCouponsPrice());
            orders.add(order);
        }


        return orders;
    }

    @Override
    public void saveOrders(Order order) {

    }

    @Override
    public List<Coupons> showCoupons(){

        List<Coupons> allCoupons = couponsDao.findAllCoupons();

        long currentTime = System.currentTimeMillis();
        allCoupons.removeIf(coupon -> coupon.getBeginTime().getTime() > currentTime || coupon.getEndTime().getTime() < currentTime);

        return allCoupons;
    }

    @Override
    public Coupons chooseCoupons(Integer couponsId){

        coupon = couponsDao.findCouponsById(couponsId);

        return coupon;
    }


    @Override
    public List<PaymentType> showPaymentType(){

        List<PaymentType> paymentTypes = paymentTypeDao.findAllPaymentType();


        return paymentTypes;
    }

    @Override
    public PaymentType choosePaymentType(Integer paymentTypeId){

        paymentType = paymentTypeDao.findPaymentTypeById(paymentTypeId);

        return paymentType;
    }

}
