package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.entity.ShoppingCart;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
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
 *
 * @Description: 购物车
 * @Author: lufang.zhang
 * @Date: 2019/10/3
 */
@Api(tags = "购物车接口")
@Controller
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加商品到购物车
     * @param session
     * @param goodsTypeId
     * @return
     */
    @ApiOperation(value = "添加商品到购物车，参数：goodsTypeId（商品详情id）")
    @PostMapping("/addGoodsToCart")
    public JsonBean<String> addGoodsToCart(HttpSession session,Integer goodsTypeId){
        //从session中获取用户信息
        User user = (User)session.getAttribute("user");
        //调用方法将商品加到购物车中
        shoppingCartService.addGoodsToCart(user,goodsTypeId);
        //如果成功，返回json数据
        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo("添加成功");
        return jb;
    }

    @ApiOperation(value ="从购物车删除商品，参数：goodsTypeId（商品详情id）" )
    @PostMapping
    public JsonBean<String> delGoodsFromCart(HttpSession session,Integer goodsTypeId){
        //从session中获取用户信息
        User user = (User)session.getAttribute("user");
        //调用方法执行删除操作
        shoppingCartService.delGoodsFromCart(user,goodsTypeId);
        //删除成功的话，返回json数据
        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo("删除成功");
        return jb;
    }

    @ApiOperation(value = "展示购物车所有商品")
    @GetMapping("/showShoppingCart")
    public JsonBean<List<ShoppingCart>> showShoppingCart(HttpSession session){

        //从session中获取用户信息
        User user = (User)session.getAttribute("user");
        //调用方法,获取购物车的商品列表
        List<ShoppingCart> list = shoppingCartService.list(user);

        JsonBean<List<ShoppingCart>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(list);

        return jb;
    }

}
