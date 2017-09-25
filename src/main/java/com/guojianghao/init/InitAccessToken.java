package com.guojianghao.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import com.alibaba.fastjson.JSON;
import com.guojianghao.cache.Cache;
import com.guojianghao.entity.weixin.Token;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;

/**
 * @Description:<p>��Ŀ������ʱ��ͻ�ȡaccess_token</p>
 * @author king
 * @date 2017��9��25�� ����4:17:57
 */
public class InitAccessToken implements InitializingBean{
	
	private static final Logger logger = LoggerFactory.getLogger(InitAccessToken.class);

	public void afterPropertiesSet() throws Exception {
		
		/*String appId = PropertiesUtil.getValue("AppID");
		String appSecrty = PropertiesUtil.getValue("AppSecret");*/
		String appId = PropertiesUtil.getValue("appID");
		String appSecrty = PropertiesUtil.getValue("appsecret");
		
		String access_token_url = PropertiesUtil.getValue("access_token_url");
		String url = access_token_url.replaceAll("APPID", appId).replaceAll("APPSECRET", appSecrty);
		try {
			logger.info("access_token_url = {}",url);
			String result = HttpUtil.getInvoke(url);
			Token token = JSON.parseObject(result, Token.class);
			Cache.putToken("token", token);
			logger.info("��ȡaccess_token �ɹ�,access_token = {}",result);
		} catch (Exception e) {
			logger.info("��ȡaccess_token ʧ��,exception = {}",e);
		}
	}

}
