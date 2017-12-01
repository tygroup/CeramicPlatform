package com.cpf.controller.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.Userinfo;
import com.cpf.service.system.UserInfoService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;


/**
 * 店铺信息管理
 * @author jll
 *2017-11-30
 */
@RestController
@RequestMapping("shop")
@Scope("prototype")
public class UserInfoController {

	@Resource
	private UserInfoService userInfoService;
	
	/**
	 * 查询精品店铺
	 * @param count
	 * @return
	 */
	
	 @RequestMapping(value = "/getBestShopList", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	 @ResponseBody
	 public JsonFormat selectBestShopList(@RequestParam(value="count", required=true) String count){
		 if(Validators.isNumeric(count)){
			 int icount = Integer.parseInt(count);
			  List<Userinfo> bestShops = userInfoService.findBestShopList(icount);
		        return bestShops!=null&&bestShops.size()>0?new JsonFormat("000000","查询成功",bestShops):new JsonFormat("000001","无数据",null);
		 }else{
			 return new JsonFormat("000002","参数错误",null);
		 }
	      
	   }
}