package com.guojianghao.service.weixin;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.guojianghao.entity.weixin.message.ContentMessage;
import com.guojianghao.util.PropertiesUtil;
import com.guojianghao.util.TempleteUtil;

@Service
public class WechatMessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(WechatMessageService.class);

	public String handelContentMessage(Map<String, String> map) {
		
		ContentMessage message = new ContentMessage();
		message.setFromUserName(map.get("ToUserName"));
		message.setToUserName(map.get("FromUserName"));
		message.setCreateTime(new Date().getTime());
		String appId = PropertiesUtil.getValue("appID");
		String autho2_get_code_url = PropertiesUtil.getValue("autho2_get_code_url");
		String redirect_uri = "http://94f216cc.ngrok.io/xxx-weixin/index";
		String url = autho2_get_code_url.replaceAll("APPID",appId).replaceAll("REDIRECTURI",redirect_uri);
		
		logger.info("获取授权code的url为：autho2_get_code_url = {}",autho2_get_code_url);
		message.setContent("欢迎来到我的公众账号<a href = \""+url+"\">点击进入</a>");
		
		String xmlMessage = TempleteUtil.getXmlMessage("contentMessage.xml", message);
		return xmlMessage;
	}

	
}
