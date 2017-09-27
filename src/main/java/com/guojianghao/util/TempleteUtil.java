package com.guojianghao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

/**
 * @Description:<p>模板引擎填充xml报文</p>
 * @author king
 * @date 2017年9月27日 下午7:46:06
 */
public class TempleteUtil {

	private static final String TEMPLETE_PATH = "/templete/";
	
	private static final Logger logger = LoggerFactory.getLogger(TempleteUtil.class);
	
	public static String getXmlMessage(String templeteName,Object dto){
		
		Configuration config = new Configuration(new Version(2,3,20));
		config.setClassForTemplateLoading(TempleteUtil.class, "/");  
		String xmlMessage = "";
		try {
			Template template = config.getTemplate(TEMPLETE_PATH + templeteName, "UTF-8");
			xmlMessage = FreeMarkerTemplateUtils.processTemplateIntoString(template, dto);
		} catch (Exception e) {
			logger.error("执行模板引擎是发生错误，exception={}", e);
		}
		return xmlMessage;
	}
}
