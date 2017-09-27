package com.guojianghao.entity.weixin.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Description:<p>消息回复基类</p>
 * @author king
 * @date 2017年9月27日 下午5:30:07
 */
public class MessageBase {

	@XStreamAlias("ToUserName")
	private String toUserName;
	@XStreamAlias("FromUserName")
	private String fromUserName;
	@XStreamAlias("CreateTime")
	private int createTime;
	@XStreamAlias("MsgType")
	private String msgType;
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public int getCreateTime() {
		return createTime;
	}
	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}
	public String getMsgType() {
		return msgType;
	}
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
}
