package com.guojianghao.cache;

import java.util.HashMap;
import java.util.Map;

import com.guojianghao.entity.weixin.Token;

public class Cache {

	private static Map<String,Token> map = new HashMap<String,Token>();
	
	public static void putToken(String key, Token token){
		map.put(key, token);
	}
	
	public static Token getToken(String key){
		return map.get(key);
	}
	
	public static void removeToken(String key){
		map.remove(key);
	}
}
