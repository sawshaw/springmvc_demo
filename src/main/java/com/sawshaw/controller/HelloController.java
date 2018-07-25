package com.sawshaw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping("/greeting")
	@ResponseBody
	public String greeting(){
		JSONObject js=new JSONObject();
		js.put("id", "myId");
		js.put("content", "mycontent");
		return js.toJSONString();
	}

}
