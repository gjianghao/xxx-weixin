package com.guojianghao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {

	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
