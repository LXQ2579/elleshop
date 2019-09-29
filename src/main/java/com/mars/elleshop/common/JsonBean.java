package com.mars.elleshop.common;




//@ApiModel
public class JsonBean<T> {

	//code标记 0 为返回数据异常  1 为返回正常数据
//	@ApiModelProperty(value = "返回数据状态码, 1 正常返回, 其他 表示异常")
	private int code;
//	@ApiModelProperty(value = "返回具体数据, 可以为null")
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
