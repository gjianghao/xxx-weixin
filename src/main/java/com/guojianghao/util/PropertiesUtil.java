package com.guojianghao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	
	private static final Properties prop = new Properties();
	
	static {
		InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream("weixin.properties");
		try {
			prop.load(is);
		} catch (IOException e) {
			logger.error("��ȡ�����ļ�ʱ�����쳣��exception={}", e);
		}
	}
	
	public static String getValue(String key){
		
		return prop.getProperty(key);
	}
}
