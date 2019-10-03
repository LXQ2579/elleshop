package com.mars.elleshop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.elleshop.dao.CouponsDao;
import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.service.UserCouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author sanriyue
 */
@Service
public class UserCouponsServiceImpl implements UserCouponsService {
    @Autowired
    CouponsDao couponsDao;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Override
    public void addCoupons(Integer couponsId) {
        Coupons couponsById = couponsDao.findCouponsById(couponsId);
    }
}
