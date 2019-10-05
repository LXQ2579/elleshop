package com.mars.elleshop.controller;

import com.mars.elleshop.common.JsonBean;
import com.mars.elleshop.dao.UserDao;
import com.mars.elleshop.entity.ShoppingCart;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.ShoppingCartService;
import com.mars.elleshop.utils.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
@Api("购物车接口")
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 添加商品到购物车
     * @param request
     * @param goodsTypeId
     * @return
     */
    @ApiOperation(value = "添加商品到购物车，参数：goodsTypeId（商品详情id）, goodsNum(商品数量)")
    @PostMapping("/addGoodsToCart")
    public JsonBean<String> addGoodsToCart(HttpServletRequest request, Integer goodsTypeId,Integer goodsNum){
        //获取用户信息
        User user = getUser(request);
        //调用方法将商品加到购物车中
        shoppingCartService.addGoodsToCart(user,goodsTypeId,goodsNum);
        //如果成功，返回json数据
        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo("添加成功");
        return jb;
    }
    @ApiOperation(value = "修改购物车商品数量 goodsNum(商品数量)")
    @PostMapping("/updateGoodsNum")
    public JsonBean<String> updateGoodsNum(HttpServletRequest request, Integer goodsTypeId,Integer goodsNum){
       //获取用户信息
        User user = getUser(request);
        shoppingCartService.updateGoodsNum(user,goodsTypeId,goodsNum);
        JsonBean<String> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo("操作成功");
        return jb;
    }

    @ApiOperation(value ="从购物车删除商品，参数：goodsTypeId（商品详情id）" )
    @PostMapping("/delGoodsFromCart")
    public JsonBean<String> delGoodsFromCart(HttpServletRequest request,String[] goodsTypeId){
        //获取用户信息
        User user = getUser(request);
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
    public JsonBean<List<ShoppingCart>> showShoppingCart(HttpServletRequest request){

        //获取用户信息
        User user = getUser(request);
        //调用方法,获取购物车的商品列表
        List<ShoppingCart> list = shoppingCartService.list(user);

        JsonBean<List<ShoppingCart>> jb = new JsonBean<>();
        jb.setCode(0);
        jb.setInfo(list);

        return jb;
    }

    /**
     * 通过token获取用户
     * @param request
     * @return
     */
    private User getUser(HttpServletRequest request){
        //获取token
        String token = request.getHeader(Constant.TOKEN);
        //获取用户电话
        String phone = redisTemplate.opsForValue().get(token);
        //获取用户信息
        User user = userDao.findByPhone(phone);
        return user;
    }

}
