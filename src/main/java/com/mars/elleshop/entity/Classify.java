package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author sanriyue
 */
@Data
@ApiModel(value = "商品细分类的属性的实体类，即属性的命名，如颜色，尺寸，尺码等")
public class Classify {
    private Integer classifyId;
    private String classifyName;
    private Integer goodsId;
}
