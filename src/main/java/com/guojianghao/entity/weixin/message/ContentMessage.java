package com.guojianghao.entity.weixin.message;

import com.alibaba.fastjson.JSON;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * @Description:<p>内容文字消息</p>
 * @author king
 * @date 2017年9月27日 下午7:08:38
 */
@XStreamAlias("xml")
public class ContentMessage extends MessageBase {

	
	@XStreamAlias("Content")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
