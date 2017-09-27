package com.guojianghao.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.guojianghao.cache.Cache;
import com.guojianghao.entity.weixin.Token;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;

/**
 * 
 * @Description:<p>定时刷新access_token</p>
 * @author king
 * @date 2017年9月27日 下午7:43:41
 */
@Component
public class AccessTokenTask {
	
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);

	@Scheduled(cron = "0 0/59 * * * ?")
	public void getAccessToken(){
		
		String appId = PropertiesUtil.getValue("AppID");
		String appSecrty = PropertiesUtil.getValue("AppSecret");
		
		String access_token_url = PropertiesUtil.getValue("access_token_url");
		String url = access_token_url.replaceAll("APPID", appId).replaceAll("APPSECRET", appSecrty);
		try {
			logger.info("access_token_url = {}",url);
			String result = HttpUtil.getInvoke(url);
			Token token = JSON.parseObject(result, Token.class);
			Cache.putToken("token", token);
			logger.info("获取access_token 成功,access_token = {}",result);
		} catch (Exception e) {
			logger.info("获取access_token 失败,exception = {}",e);
		}
	}
}
