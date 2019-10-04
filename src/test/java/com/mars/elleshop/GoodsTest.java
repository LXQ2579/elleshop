package com.mars.elleshop;

import com.mars.elleshop.dao.GoodsDao;
import com.mars.elleshop.entity.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
    @Autowired
    GoodsDao goodsDao;

    @Test
    public void testFindById(){
        Goods goodsById = goodsDao.findGoodsById(1);
        System.out.println(goodsById);
    }
}
