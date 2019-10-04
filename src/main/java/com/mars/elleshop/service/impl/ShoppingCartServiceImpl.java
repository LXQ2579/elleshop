package com.mars.elleshop.service.impl;

import com.mars.elleshop.dao.GoodsTypeDao;
import com.mars.elleshop.entity.Goods;
import com.mars.elleshop.entity.GoodsType;
import com.mars.elleshop.entity.ShoppingCart;
import com.mars.elleshop.entity.User;
import com.mars.elleshop.service.ShoppingCartService;
import com.mars.elleshop.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
 * @Date: 2019/10/3
 */
@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private static final String CART_KEY = "shoppingCart";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private GoodsTypeDao goodsTypeDao;

    /**
     * 添加商品到购物车
     * @param user
     * @param goodsTypeId
     */
    @Override
    public void addGoodsToCart(User user, Integer goodsTypeId){
        isNull(user);
        //获取商品详情
        GoodsType goodsType = goodsTypeDao.findGoodsTypeById(goodsTypeId);
        //封装进购物车实体类
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setGoodsType(goodsType);
        //将对象转换成json数据，方便存进redis
        String jsonData = JsonUtils.objectToJson(shoppingCart);
        //加入购物车
        redisTemplate.opsForHash().put(user.getUid()+CART_KEY,goodsTypeId+"",jsonData);
    }


    /**
     * 从购物车删除商品
     * @param user 用户
     * @param goodsTypeId
     */
    @Override
    public void delGoodsFromCart(User user,Integer goodsTypeId){
        isNull(user);
        if(goodsTypeId == null){
            throw new RuntimeException("商品不存在");
        }
        //从购物车删除
        redisTemplate.opsForHash().delete(user.getUid()+CART_KEY,goodsTypeId+"");
    }

    /**
     *
     * 得到购物车的商品列表
     * @param user
     * @return
     */
    @Override
    public List<ShoppingCart> list(User user){
        isNull(user);
        List<Object> values = redisTemplate.opsForHash().values(user.getUid()+CART_KEY);
        List<ShoppingCart> goodsList = JsonUtils.jsonToList(values.toString(),ShoppingCart.class);
        return goodsList;
    }


    private void  isNull(User user){
        if(user == null){
            throw new RuntimeException("用户未登录，请登录");
        }
    }

}
