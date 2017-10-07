package com.guojianghao.entity.weixin.autho2;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * @Description:<p>微信用户信息</p>
 * @author king
 * @date 2017年10月7日 上午10:53:05
 */
public class UserInfo {

	/*{    "openid":" OPENID",  
		 " nickname": NICKNAME,   
		 "sex":"1",   
		 "province":"PROVINCE"   
		 "city":"CITY",   
		 "country":"COUNTRY",    
		 "headimgurl":    "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ
		4eMsv84eavHiaiceqxibJxCfHe/46",  
		"privilege":[ "PRIVILEGE1" "PRIVILEGE2"     ],    
		 "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" 
		} */
	
	private String openid;
	private String nickname;
	private String sex;
	private String province;
	private String city;
	private String country;
	private String headimgurl;
	private List<String> privilege = new ArrayList<String>();
	private String unionid;
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public List<String> getPrivilege() {
		return privilege;
	}
	public void setPrivilege(List<String> privilege) {
		this.privilege = privilege;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
