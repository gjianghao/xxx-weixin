package com.guojianghao.controller.weixin;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.guojianghao.cache.Cache;
import com.guojianghao.entity.weixin.Token;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;
import com.guojianghao.util.SignUtil;

/**
 * @Description:<p>微信接入</p>
 * @author king
 * @date 2017年9月25日 上午11:08:04
 */
@Controller
@RequestMapping("/wechat")
public class WechatController {
	
	private static final Logger logger = LoggerFactory.getLogger(WechatController.class);
	
	/**
	 * 接入
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
	
	@RequestMapping(value = "/access", method = RequestMethod.POST)
	public void wechatPost(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		InputStream is = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(is);
		Element element = doc.getRootElement();
		
		Iterator<Element> it = element.elementIterator();
		while(it.hasNext()){
			Element e = it.next();
			System.out.println(e.getName()+"--------------"+e.getText());
		}
		
	}
	
	/**
	 * 获取access_token并缓存,增加定时任务，api接口暂时保留。
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
			logger.info("获取access_token 成功,access_token = {}",result);
		} catch (Exception e) {
			logger.info("获取access_token 失败,exception = {}",e);
		}
		return token;
	}
	
	
}
