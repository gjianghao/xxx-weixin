package com.guojianghao.entity.weixin.message;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @Description:<p>视频消息</p>
 * @author king
 * @date 2017年9月27日 下午7:12:39
 */
@XStreamAlias("xml")
public class VideoMessage extends MessageBase{

	@XStreamAlias("MediaId")
	private String mediaId;
	
	@XStreamAlias("Title")
	private String title;
	
	@XStreamAlias("Description")
	private String description;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

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
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
