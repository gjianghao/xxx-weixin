package com.guojianghao.util;

import java.util.HashMap;
import java.util.Map;

public interface Constant {

	public class Security{
		public static final String SALT = "xxxx";
	}
	
	public class Wechat{
		
		/** ָ���������,���õļ���,�����õ�ʲô�Լ����*/
		public static Map<String,String> CLICK_TYPE = new HashMap<String,String>();
		static{
			CLICK_TYPE.put("click", "click");
			CLICK_TYPE.put("view", "view");
		}
	}
}
