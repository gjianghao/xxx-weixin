package com.guojianghao.controller.weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.guojianghao.cache.Cache;
import com.guojianghao.entity.weixin.MessageInfo;
import com.guojianghao.entity.weixin.WechatMenu;
import com.guojianghao.util.Constant;
import com.guojianghao.util.HttpUtil;
import com.guojianghao.util.PropertiesUtil;

@RequestMapping("/wechatmenu")
public class MenuManageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuManageController.class);

	/**
	 * 创建自定义菜单,先做测试用,后面接受admin传来的参数
	 */
	@RequestMapping(value = "/createMenu",method = RequestMethod.POST)
	@ResponseBody
	public Object createMenu(){
		
		Map<String,List<WechatMenu>> map = new HashMap<String,List<WechatMenu>>();
		
		List<WechatMenu> list = new ArrayList<WechatMenu>();
		
		WechatMenu menu = new WechatMenu();
		menu.setName("菜单一");
		menu.setKey("V1001_MENU1");
		menu.setType(Constant.Wechat.CLICK_TYPE.get("click"));
		
		WechatMenu menu2 = new WechatMenu();
		menu2.setName("菜单二");
		menu2.setUrl("http://www.baidu.com");
		menu2.setType(Constant.Wechat.CLICK_TYPE.get("view"));
		
		WechatMenu menu3 = new WechatMenu();
		menu3.setName("菜单三");
		
		WechatMenu menu31 = new WechatMenu();
		menu31.setName("子菜单一");
		menu31.setKey("V1001_MENU1");
		menu31.setType(Constant.Wechat.CLICK_TYPE.get("click"));
		
		WechatMenu menu32 = new WechatMenu();
		menu32.setName("子菜单二");
		menu32.setUrl("http://www.baidu.com");
		menu32.setType(Constant.Wechat.CLICK_TYPE.get("view"));
		
		menu3.getSub_button().add(menu31);
		menu3.getSub_button().add(menu32);
		
		list.add(menu);
		list.add(menu2);
		list.add(menu3);
		
		map.put("button", list);
		String json = JSON.toJSONString(map);
		String create_menu_url = PropertiesUtil.getValue("create_menu_url");
		String url = create_menu_url.replaceAll("ACCESS_TOKEN", Cache.getToken("token").getAccess_token());
		String result = "";
		try {
			logger.info("菜单参数为：params = {}",json);
			result = HttpUtil.postInvoke(url,json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MessageInfo message = JSON.parseObject(result, MessageInfo.class);
		String status = "success";
		if(message.getErrcode() != 0){
			status = "fail";
		}
		logger.info("创建菜单返回消息为：messageInfo={}",message);
		return status;
	}
	
	/**
	 * 菜单查询
	 * @return
	 */
	@RequestMapping(value = "/queryMenuList", method = RequestMethod.GET)
	@ResponseBody
	public Object queryMenuList(){
		
		String query_menu_url = PropertiesUtil.getValue("query_menu_url");
		String url = query_menu_url.replaceAll("ACCESS_TOKEN", Cache.getToken("token").getAccess_token());
		String result = HttpUtil.getInvoke(url);
		MessageInfo message = JSON.parseObject(result, MessageInfo.class);
		return message;
	}
	
	/**
	 * 删除所有菜单，慎用
	 * @return
	 */
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.GET)
	@ResponseBody
	public Object deleteMenu(){
		
		String delete_menu_url = PropertiesUtil.getValue("delete_menu_url");
		String url = delete_menu_url.replaceAll("ACCESS_TOKEN", Cache.getToken("token").getAccess_token());
		String result = HttpUtil.getInvoke(url);
		MessageInfo message = JSON.parseObject(result, MessageInfo.class);
		return message;
	}
}
