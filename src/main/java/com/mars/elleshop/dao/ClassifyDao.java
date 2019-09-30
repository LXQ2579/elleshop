package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Classify;
import org.springframework.stereotype.Repository;

/**
 * @author sanriyue
 */
@Repository
public interface ClassifyDao {

    Classify findClassifyById(Integer classifyId);
}
