package com.mars.elleshop.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liujiulong
 * @date 2019/10/05  10:24:00
 */
@ApiModel(value ="时尚头条实体类, 一个时尚头条的文章一个实体类")
@Getter
@Setter
public class Headline implements Serializable {

    @ApiModelProperty(value = "头条的id")
    private Integer headlineId;
    @ApiModelProperty(value = "头条的图片")
    private String imgUrl;
    @ApiModelProperty(value = "头条的标题")
    private String title;
    @ApiModelProperty(value = "头条的简介, 可以为空")
    private String intro;
    @ApiModelProperty(value = "头条的阅读量")
    private Integer pageView;
    @ApiModelProperty(value = "头条的评论量")
    private Integer commentCount;
    @ApiModelProperty(value = "头条的类型, dj为独家, mx为明星, sp为视频, hw为买手好物, hb为直播红包")
    private String type;

}
