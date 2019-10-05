package com.mars.elleshop.service;

import com.mars.elleshop.entity.Headline;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/05  10:47:00
 */
public interface HeadlineService {

    List<Headline> showHeadline(String type);
}
