package com.guojianghao.entity.weixin;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Description:<p>微信菜单实体</p>
 * @author king
 * @date 2017年9月25日 下午3:21:55
 */
public class WechatMenu {

	private String name;
	private String type;
	private String key;
	private List<WechatMenu> sub_button = new ArrayList<WechatMenu>();
	private String url;
	private String media_id;
	//小程序相关，暂且可能用不到
	private String appid;
	private String pagepath;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<WechatMenu> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<WechatMenu> sub_button) {
		this.sub_button = sub_button;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
