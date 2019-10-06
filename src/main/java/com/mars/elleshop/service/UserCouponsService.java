package com.mars.elleshop.service;

import com.mars.elleshop.entity.Coupons;

import java.util.List;

/**
 * @author sanriyue
 */
public interface UserCouponsService {
    void addCoupons(Integer couponsId,String token);

    List<Coupons> findAllCoupons();

    public  List<Coupons> findAllCouponsOnUser(String token);
}
