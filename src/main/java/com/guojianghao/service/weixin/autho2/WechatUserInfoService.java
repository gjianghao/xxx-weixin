package com.guojianghao.service.weixin.autho2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guojianghao.entity.weixin.autho2.WechatUserinfo;
import com.guojianghao.mapper.weixin.autho2.WechatUserinfoMapper;

@Service
public class WechatUserInfoService {

	@Autowired
	private WechatUserinfoMapper wechatUserinfoMapper;
	
	public int insertWechatUser(WechatUserinfo info){
		
		return wechatUserinfoMapper.insertSelective(info);
	}
}
