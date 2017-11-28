package com.cpf.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpf.beans.Test;
import com.cpf.resource.common.UUIDGenerator;
import com.cpf.service.TestService;

@Controller
@RequestMapping("testController")
public class TestController {
	 @Autowired
	 private TestService uu;
	 
	 @RequestMapping("/insert") 
	 @ResponseBody
	 public JSONObject insert(){
		 JSONObject obj = new JSONObject();
		 Test tt=new Test();
		 tt.setId(UUIDGenerator.getUUID());
		 tt.setName("test01");
		 tt.setPvalue("测试数据......");
		 uu.insert(tt);
		 obj.accumulate("result",JSONObject.fromObject(tt));
		 return obj;
	 }
	 
	 
	 
	 @RequestMapping("/getAll")
	 @ResponseBody 
	 public JSONObject getAll(){
		 JSONObject obj = new JSONObject();
		 List tt = uu.getAll();
		 obj.put("result",JSONArray.fromObject(tt));
		 return obj;
	 }

}
