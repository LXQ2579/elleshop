package com.mars.elleshop.common;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class JsonBean<T> {

	@ApiModelProperty(value = "返回数据状态码, 0 正常返回, 其他 表示异常")
	private int code;
	@ApiModelProperty(value = "返回具体数据, 可以为null")
	private T info;

	public JsonBean() {
	}

	public JsonBean(int code, T info) {
		this.code = code;
		this.info = info;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
}
