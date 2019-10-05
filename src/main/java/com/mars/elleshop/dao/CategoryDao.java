package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Category;

import java.util.List;

/**
 * @author leizhonggang
 */

public interface CategoryDao {

    /**
     * 查找到所有分类展示到页面上
     * @return
     */
    public List<Category> getAllKinds();
}
