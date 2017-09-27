package com.guojianghao.entity.weixin.message;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Description:<p>图文消息</p>
 * @author king
 * @date 2017年9月27日 下午7:18:52
 */
public class ArticlesMessage extends MessageBase{
	
	private String title;
	private String description;
	private String picUrl;
	private String url;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
