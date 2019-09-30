package com.mars.elleshop;

import com.mars.elleshop.entity.Category;
import com.mars.elleshop.service.CategoryService;
import com.mars.elleshop.service.impl.CategoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElleshopApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void contextLoads() {
        List<Category> allKinds = categoryService.getAllKinds();
        System.out.println(allKinds);

    }

}
