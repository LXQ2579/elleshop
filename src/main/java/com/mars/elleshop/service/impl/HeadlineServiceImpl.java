package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.HeadlineDao;
import com.mars.elleshop.entity.Headline;
import com.mars.elleshop.service.HeadlineService;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/05  10:48:00
 */
@Service
public class HeadlineServiceImpl implements HeadlineService {

    @Autowired
    private HeadlineDao headlineDao;

    @Override
    public List<Headline> showHeadline(String type) {

        if (type == null){
            throw new RuntimeException("该模块还未开发, 敬请期待...");
        }

        Headline headline = new Headline();
        List<Headline> list = headlineDao.findByType(type);


        return list;
    }
}
