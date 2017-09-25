package com.guojianghao.util;

import java.util.HashMap;
import java.util.Map;

public interface Constant {

	public class Security{
		public static final String SALT = "xxxx";
	}
	
	public class Wechat{
		
		/** 指定点击类型,常用的几种,后续用到什么自己添加*/
		public static Map<String,String> CLICK_TYPE = new HashMap<String,String>();
		static{
			CLICK_TYPE.put("click", "click");
			CLICK_TYPE.put("view", "view");
		}
	}
}
