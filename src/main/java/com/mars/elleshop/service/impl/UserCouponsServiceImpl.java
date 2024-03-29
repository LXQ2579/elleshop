package com.mars.elleshop.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mars.elleshop.dao.CouponsDao;
import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.service.UserCouponsService;
import com.mars.elleshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void addCoupons(Integer couponsId,String token) {
        Coupons couponsById = couponsDao.findCouponsById(couponsId);

        String phone = stringRedisTemplate.opsForValue().get(token);

        stringRedisTemplate.opsForHash().put(phone+"coupons",couponsId+"", JsonUtils.objectToJson(couponsById));


    }

    @Override
    public List<Coupons> findAllCoupons() {
        return couponsDao.findAllCoupons();
    }

    @Override
    public  List<Coupons> findAllCouponsOnUser(String token){
        String phone = stringRedisTemplate.opsForValue().get(token);
        List<Object> values = stringRedisTemplate.opsForHash().values(phone + "coupons");
        List<Coupons> couponsList = JsonUtils.jsonToList(values.toString(), Coupons.class);
        if (couponsList==null){
            throw new RuntimeException("该用户没有优惠券");
        }
        return couponsList;
    }
}
