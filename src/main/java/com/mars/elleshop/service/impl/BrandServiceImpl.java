package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.BrandDao;
import com.mars.elleshop.entity.Area;
import com.mars.elleshop.entity.Brand;
import com.mars.elleshop.entity.Category;
import com.mars.elleshop.entity.Style;
import com.mars.elleshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    @Autowired(required = false)
    private BrandDao brandDao;
    /**
     * 查找所有品牌，按照A-Z规则排序
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandDao.findAll();
    }

    /**
     * 查找所有品牌，按照热门排序显示
     *
     * @return
     */
    @Override
    public List<Brand> findAllByPopular() {
        return brandDao.findAllByPopular();
    }

    /**
     * 按分类查找所有品牌
     *
     * @return
     */
    @Override
    public List<Category> findAllBrandByCategory() {
        return brandDao.findAllBrandByCategory();
    }

    /**
     * 按风格查找所有品牌
     *
     * @return
     */
    @Override
    public List<Style> findAllBrandByStyle() {
        return brandDao.findAllBrandByStyle();
    }

    /**
     * 按地区查找所有品牌
     *
     * @return
     */
    @Override
    public List<Area> findAllBrandByArea() {
        return brandDao.findAllBrandByArea();
    }
}
