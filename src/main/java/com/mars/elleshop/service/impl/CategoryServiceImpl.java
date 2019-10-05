package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.CategoryDao;
import com.mars.elleshop.entity.Category;
import com.mars.elleshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leizhonggang
 */

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;


    @Override
    public List<Category> getAllKinds() {
        List<Category> allKinds = categoryDao.getAllKinds();
        return allKinds;
    }
}
