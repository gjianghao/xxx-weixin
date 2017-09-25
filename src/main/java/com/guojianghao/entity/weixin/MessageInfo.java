package com.guojianghao.entity.weixin;

import com.alibaba.fastjson.JSON;

/**
 * @Description:<p>������Ϣ</p>
 * @author king
 * @date 2017��9��25�� ����3:52:46
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
