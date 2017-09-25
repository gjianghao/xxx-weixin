package com.guojianghao.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:<p>http工具类</p>
 * @author king
 * @date 2017年9月25日 下午4:00:59
 */
public final class HttpUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	/**
	 * http get请求
	 * @param url
	 * @return
	 */
	public static String getInvoke(String url){
		String result = "";
		HttpRequestBase httpRequestBase = null;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(6000)
					.setConnectionRequestTimeout(6000)
					.setSocketTimeout(6000)
					.build();
			HttpGet get = new HttpGet(url);
			get.setConfig(requestConfig);
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			logger.error("请求服务器发生异常,异常信息，exception={}", e);
		} finally {
			if(httpRequestBase != null){
				httpRequestBase.releaseConnection();
			}
		}
		return result;
	}
	
	/**
	 * http post 参数在body体中
	 * @param url
	 * @param params
	 * @return
	 */
	public static String postInvoke(String url,String params){
		String result = "";
		HttpRequestBase httpRequestBase = null;
		try {
			HttpClient client = HttpClientBuilder.create().build();
			RequestConfig requestConfig = RequestConfig.custom()
					.setConnectTimeout(6000)
					.setConnectionRequestTimeout(6000)
					.setSocketTimeout(6000)
					.build();
			StringEntity stringEntity = new StringEntity(params, "utf-8");
			stringEntity.setContentEncoding("UTF-8");    
			stringEntity.setContentType("application/json"); 
			HttpPost post = new HttpPost(url);
			post.setConfig(requestConfig);
			post.setEntity(stringEntity);
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity entity = response.getEntity();
				result = EntityUtils.toString(entity);
			}
		} catch (Exception e) {
			logger.error("请求服务器发生异常,异常信息，exception={}", e);
		} finally {
			if(httpRequestBase != null){
				httpRequestBase.releaseConnection();
			}
		}
		return result;
	}
}
