package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Headline;
import com.mars.elleshop.service.HeadlineService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liujiulong
 * @date 2019/10/05  10:57:00
 */
@Api("时尚头条API")
@RestController
@RequestMapping(path = "/headline")
public class HeadlineController {

    @Autowired
    private HeadlineService headlineService;

    @PostMapping("/showHeadline.do")
    @ApiOperation(value="获取时尚头条信息", notes="通过头条的类型获取头条信息, 头条的类型<type>, dj为独家, mx为明星, sp为视频, hw为买手好物, hb为直播红包")
    public JsonBean<List<Headline>> showHeadline(String type){

        List<Headline> headlines = headlineService.showHeadline(type);

        return new JsonBean<>(0, headlines);

    }
}
