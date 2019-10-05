package com.mars.elleshop.dao;

import com.mars.elleshop.entity.Headline;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/05  10:45:00
 */
@Repository
public interface HeadlineDao {

    List<Headline> findByType(String type);

}
