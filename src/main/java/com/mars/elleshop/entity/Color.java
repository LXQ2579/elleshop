package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author sanriyue
 */
@ApiModel(value = "商品细分类的具体属性1，主要是颜色，样式的分类，为容易区分统一写成color")
@Data
public class Color implements Serializable {
    private Integer colorId;
    @ApiModelProperty(value = "这个属性的具体内容，如蓝色，白色，羊皮，等")
    private String colorName;
    private Integer classifyIdColor;
}
