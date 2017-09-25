package com.guojianghao.controller.weixin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.guojianghao.cache.Cache;
import com.guojianghao.entity.weixin.MessageInfo;
import com.guojianghao.entity.weixin.Token;
import com.guojianghao.entity.weixin.WechatMenu;
import com.guojianghao.util.Constant;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;
import com.guojianghao.util.SignUtil;

/**
 * @Description:<p>΢�Ž���</p>
 * @author king
 * @date 2017��9��25�� ����11:08:04
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
	
	private static final Logger logger = LoggerFactory.getLogger(WechatController.class);
	
	/**
	 * ����
	 */
	@RequestMapping(value = "/access", method = RequestMethod.GET)
	public void wechatGet(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "signature") String signature,
			@RequestParam(value = "timestamp") String timestamp,
			@RequestParam(value = "nonce") String nonce,
			@RequestParam(value = "echostr") String echostr) {

		String token = PropertiesUtil.getValue("Token");
		if (SignUtil.checkSignature(token, signature,
				timestamp, nonce)) {
			try {
				response.getWriter().print(echostr);
				logger.info("wechat access success");
			} catch (IOException e) {
				logger.info("wechat access faild , exception = {}",e);
			}
		}
	}
	
	/**
	 * ��ȡaccess_token������,���Ӷ�ʱ����api�ӿ���ʱ������
	 */
	@RequestMapping(value = "/getAccessToken", method = RequestMethod.GET)
	@ResponseBody
	public Object getAccessToken(){
		
		String appId = PropertiesUtil.getValue("AppID");
		String appSecrty = PropertiesUtil.getValue("AppSecret");
		
		String access_token_url = PropertiesUtil.getValue("access_token_url");
		String url = access_token_url.replaceAll("APPID", appId).replaceAll("APPSECRET", appSecrty);
		Token token = null;
		try {
			logger.info("access_token_url = {}",url);
			String result = HttpUtil.getInvoke(url);
			token = JSON.parseObject(result, Token.class);
			Cache.putToken("token", token);
			logger.info("��ȡaccess_token �ɹ�,access_token = {}",result);
		} catch (Exception e) {
			logger.info("��ȡaccess_token ʧ��,exception = {}",e);
		}
		return token;
	}
	
	
}
