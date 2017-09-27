package com.guojianghao.entity.weixin.message;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @Description:<p>语音消息</p>
 * @author king
 * @date 2017年9月27日 下午7:07:56
 */
@XStreamAlias("xml")
public class VoiceMessage extends MessageBase{

	@XStreamAlias("MediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
