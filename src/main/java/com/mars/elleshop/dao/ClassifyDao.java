package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Classify;
import com.mars.elleshop.entity.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sanriyue
 */
@Repository
public interface ClassifyDao {

    List<Classify> findClassIfyByGoodsId(Integer goodsId);

    Classify findClassifyById(Integer classifyId);
}
