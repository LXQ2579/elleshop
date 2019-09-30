package com.mars.elleshop;

import com.mars.elleshop.dao.ClassifyDao;
import com.mars.elleshop.entity.Classify;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassifyTest {
    @Autowired
    ClassifyDao classifyDao;
    @Test
    public void testFindById(){
        Classify classifyById = classifyDao.findClassifyById(1);
        System.out.println(classifyById);
    }
}
