package com.mars.elleshop;

import com.mars.elleshop.dao.GoodsTypeDao;
import com.mars.elleshop.entity.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTypeTest {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Test
    public void testFindById(){
        GoodsType byId = goodsTypeDao.findGoodsTypeById(1);
        System.out.println(byId);
    }
}
