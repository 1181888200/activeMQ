package com.lwl.activemq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lwl.activemq.respone.ResultRespone;

@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public ResultRespone index(){
		ResultRespone respone = new ResultRespone();
		respone.setData("欢迎来到我的界面");
		return respone;
	}
	
}
