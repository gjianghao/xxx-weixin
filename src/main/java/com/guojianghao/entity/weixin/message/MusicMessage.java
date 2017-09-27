package com.guojianghao.entity.weixin.message;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Description:<p>音乐消息</p>
 * @author king
 * @date 2017年9月27日 下午7:14:16
 */
//@XStreamAlias("xml")
public class MusicMessage extends MessageBase{

	private String title;
	private String description;
	private String musicUrl;
	private String hQMusicUrl;
	private String thumbMediaId;
	
	
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


	public String getMusicUrl() {
		return musicUrl;
	}


	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}


	public String gethQMusicUrl() {
		return hQMusicUrl;
	}


	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}


	public String getThumbMediaId() {
		return thumbMediaId;
	}


	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}


	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
