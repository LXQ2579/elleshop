package com.mars.elleshop;

import com.mars.elleshop.dao.CouponsDao;
import com.mars.elleshop.entity.Coupons;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponsTest {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    CouponsDao couponsDao;

    @Test
    public void testFindById(){
        Coupons couponsById = couponsDao.findCouponsById(1);
        System.out.println(couponsById);
    }

    @Test
    public void testFindAll(){
        List<Coupons> allCoupons = couponsDao.findAllCoupons();
        for (Coupons allCoupon : allCoupons) {
            System.out.println(allCoupon);
        }

    }
    @Test
    public void testRedis(){
        User user = new User();

        stringRedisTemplate.opsForHash().put(111+"coupons",1+"",
                user.toString());

    }
}
