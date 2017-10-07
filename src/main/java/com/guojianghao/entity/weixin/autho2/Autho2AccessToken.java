package com.guojianghao.entity.weixin.autho2;

import com.alibaba.fastjson.JSON;

/**
 * @Description:<p>autho2认证access_token实体</p>
 * @author king
 * @date 2017年10月7日 上午10:53:26
 */
public class Autho2AccessToken {
	
	/*{
	    "access_token": "CootnM2PFWHrxdKUotkYucrLNNobK6e453bqfhp1rkWuW2q7jblJm0Z69dmsJCch7CnSwSE302cRLxDJC2D9CgO_MiQ4mPp02Z65uUXme3k",
	    "expires_in": 7200,
	    "refresh_token": "c2ov2NyT9pEiV8CubRGiJqNYWHU_ayVl3SpNGzyhG_WQLd9zfvPHPFciFuKItDcJdb8K4nHgCc2mzbmKbrxhh2RA_66_LHHfGm0OWPrbgis",
	    "openid": "oeo9Yv-Xg5VYJTG2XDOdqGDbxuIQ",
	    "scope": "snsapi_userinfo"
	}*/

	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	
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
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
