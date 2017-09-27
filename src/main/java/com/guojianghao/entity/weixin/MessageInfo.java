package com.guojianghao.entity.weixin;

import com.alibaba.fastjson.JSON;

/**
 * @Description:<p>接口返回消息</p>
 * @author king
 * @date 2017年9月27日 下午7:42:08
 */
public class MessageInfo {
	
//	{"errcode":0,"errmsg":"ok"}
	private int errcode;
	private String errmsg ;
	
	public int getErrcode() {
		return errcode;
	}
	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}
	public String getErrmsg() {
		return errmsg;
	}
	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
