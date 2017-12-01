package com.cpf.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.SysCollect;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.service.system.ProductService;
import com.cpf.service.system.SysCollectService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;

/**
 * 用户中心--收藏管理
 * @author jml
 * @date 2017-11-30
 */
@RestController
@RequestMapping("Collections")
@Scope("prototype")
public class SysCollectController {
	@Autowired
	private SysCollectService service;
	
	/**
	 * 查看我的收藏列表   商品，专场，店铺查询sql不一样，须加判断！！0商品2专场3店铺
	 * @return
	 */
    @RequestMapping(value = "/findCollectsByUserId", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat findCollectsByUserId(@RequestParam(value="type", required=true) String type,@RequestParam(value="userId", required=true) String userId,@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
            int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int endIndex = Integer.parseInt(cpage)*Integer.parseInt(pageSize);
            List<SysCollect> OfficialSpecials = service.findByUserid(type, userId, beginIndex, endIndex);
			int totalCount = service.findByUseridCount(type, userId) ;
		    return OfficialSpecials!=null&&OfficialSpecials.size()>0?new JsonFormat("000000","查询成功",totalCount,OfficialSpecials):new JsonFormat("000001","无数据",0,null);
		 }else{
			 return new JsonFormat("000002","参数错误",null);
		 }
    }
}
