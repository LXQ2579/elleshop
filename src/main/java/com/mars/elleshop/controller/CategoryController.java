package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Category;
import com.mars.elleshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public JsonBean<List> getAllKinds(){

        List<Category> allKinds = categoryService.getAllKinds();

        return new JsonBean(1,allKinds);

    }


}
