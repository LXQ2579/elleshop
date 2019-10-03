package com.mars.elleshop;

import com.mars.elleshop.dao.CouponsDao;
import com.mars.elleshop.entity.Coupons;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CouponsTest {
    @Autowired
    CouponsDao couponsDao;

    @Test
    public void testFindById(){
        Coupons couponsById = couponsDao.findCouponsById(1);
        System.out.println(couponsById);
    }
}
