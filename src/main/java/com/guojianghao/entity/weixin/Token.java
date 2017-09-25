package com.guojianghao.entity.weixin;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @Description:<p>token 实体</p>
 * @author king
 * @date 2017年9月25日 下午2:50:35
 */
public class Token {

//	{"access_token":"HifBxt8WP5sZ1HiAPYWZtZ9J1PHNdS5IXn79et9i9Vl7AtRTNfLYHR4kUfT3njza9Bn91MykCtZkM7ZzqDaDNywAjIBkuuTOKeO0iAvSK3jLw898yBJnVloHBQqdZY7XXSOiAGAKFB","expires_in":7200}
	
	private String access_token;
	private int expires_in;
	
	public Token() {}
	
	public Token(String access_token,int expires_in) {
		
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
