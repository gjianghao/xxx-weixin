package com.guojianghao.controller.weixin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.guojianghao.entity.weixin.autho2.Autho2AccessToken;
import com.guojianghao.entity.weixin.autho2.WechatUserinfo;
import com.guojianghao.service.weixin.autho2.WechatUserInfoService;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private WechatUserInfoService wechatUserInfoService;

	@RequestMapping("/index")
	public String index(String code,String state){
		
		String appId = PropertiesUtil.getValue("appID");
		String appsecret = PropertiesUtil.getValue("appsecret");
		String autho2_access_token_url = PropertiesUtil.getValue("autho2_access_token_url");
		
		String url = autho2_access_token_url.replaceAll("APPID", appId)
				.replaceAll("SECRET", appsecret)
				.replaceAll("CODE", code);
		
		String result = HttpUtil.getInvoke(url);
		logger.info("获取autho2_access_token 的返回报文为：{}",result);
		Autho2AccessToken aat = JSON.parseObject(result, Autho2AccessToken.class);
		
		String autho2_refresh_access_token_url = PropertiesUtil.getValue("autho2_refresh_access_token_url");
		String refresh_url = autho2_refresh_access_token_url.replaceAll("APPID", appId)
				.replaceAll("REFRESH_TOKEN", aat.getRefresh_token());
		result = HttpUtil.getInvoke(refresh_url);
		aat = JSON.parseObject(result, Autho2AccessToken.class);
		logger.info("刷新后的autho2_access_token 的返回报文为：{}",aat);
		
		String autho2_get_userinfo_url = PropertiesUtil.getValue("autho2_get_userinfo_url");
		String userinfo_url = autho2_get_userinfo_url.replaceAll("ACCESS_TOKEN", aat.getAccess_token())
				.replaceAll("OPENID", aat.getOpenid());
		result = HttpUtil.getInvoke(userinfo_url);
		logger.info("拉去用户信息返回报文为：{}",result);
//		UserInfo userInfo = JSON.parseObject(result, UserInfo.class);
		WechatUserinfo userInfo = JSON.parseObject(result, WechatUserinfo.class);
		logger.info("拉去用户信息返回实体为：{}",userInfo);
		wechatUserInfoService.insertWechatUser(userInfo);
		
		return "index";
	}
}
