package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.Area;
import com.mars.elleshop.entity.Brand;
import com.mars.elleshop.entity.Category;
import com.mars.elleshop.entity.Style;
import com.mars.elleshop.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *                     .::::.
 *                  .::::::::.
 *                 :::::::::::
 *             ..:::::::::::'
 *           '::::::::::::'
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 *         女神镇楼                 BUG辟易
 *  佛曰:
 *          写字楼里写字间，写字间里程序员；
 *          程序人员写程序，又拿程序换酒钱。
 *          酒醒只在网上坐，酒醉还来网下眠；
 *          酒醉酒醒日复日，网上网下年复年。
 *          但愿老死电脑间，不愿鞠躬老板前；
 *          奔驰宝马贵者趣，公交自行程序员。
 *          别人笑我忒疯癫，我笑自己命太贱；
 *          只见满街漂亮妹，哪个得归程序员？
 * @Description:
 * @Author: lufang.zhang
 * @Date: 2019/9/30
 */

@Api("品牌馆API")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 查找所有品牌，按照指定规则排序
     * @return JsonBean
     */
    @ApiOperation(value = "显示品牌时，按照名字A-Z顺序显示")
    @GetMapping("/findAllBrand")
    public JsonBean<List<Brand>> findAllBrand(){
        List<Brand> brandList = brandService.findAll();
        JsonBean<List<Brand>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(brandList);
        return jb;
    }

    @ApiOperation(value = "显示品牌时，根据热门排序显示")
    @GetMapping("/showBrandByPopular")
    public JsonBean<List<Brand>> showBrandByPopular(){
        List<Brand> brandList = brandService.findAllByPopular();
        JsonBean<List<Brand>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(brandList);
        return jb;
    }

    @ApiOperation(value = "按照分类显示品牌")
    @GetMapping("/showBrandByCategory")
    public JsonBean<List<Category>> showBrandByCategory(){
        List<Category> categoryBrandList = brandService.findAllBrandByCategory();
        JsonBean<List<Category>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(categoryBrandList);
        return jb;
    }

    @ApiOperation(value = "按照风格显示品牌")
    @GetMapping("/showBrandByStyle")
    public JsonBean<List<Style>> showBrandByStyle(){
        List<Style> styleBrandList = brandService.findAllBrandByStyle();
        JsonBean<List<Style>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(styleBrandList);
        return jb;
    }

    @ApiOperation(value = "按照地区显示品牌")
    @GetMapping("/showBrandByArea")
    public JsonBean<List<Area>> showBrandByArea(){
        List<Area> areaBrandList = brandService.findAllBrandByArea();
        JsonBean<List<Area>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(areaBrandList);
        return jb;
    }


}
