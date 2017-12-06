package com.cpf.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.SysCollect;
import com.cpf.resource.common.UUIDGenerator;
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
    /**
     * 保存用户的收藏  jll  2017-12-05
     * @param collect
     * @return
     */
    @RequestMapping(value = "/saveCollect", method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat findCollectsByUserId(@RequestBody SysCollect collect){
    	collect.setCollectid(UUIDGenerator.getUUID());
    	try{
    	String collectId = service.saveCollect(collect);
    	return !"".equals(collectId)&&collectId!=null?new JsonFormat("000000", "保存成功", collectId):new JsonFormat("000000", "保存成功", null);
    	}catch(Exception de){
    		return new JsonFormat("000003", "服务异常，请重试", null);
    	}
    }
    
    /**
     * 判断用户是否收藏过 这个id  jll  2017-12-05
     * @param type
     * @param userId
     * @param id
     * @return
     */
    @RequestMapping(value = "/isCollected", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectCollectedInfo(@RequestParam(value="type", required=true) String type,@RequestParam(value="userId", required=true) String userId,@RequestParam(value="id", required=true) String id){
    	try{
    	List<SysCollect>  collect = service.selectCollectInfo(id, type, userId);
		return collect!=null&&collect.size()>0?new JsonFormat("000000","查询成功",collect.get(0)):new JsonFormat("000001","无数据",0,null);
    	}catch(Exception de){
    		return new JsonFormat("000003", "服务异常，请重试", null);
    	}
    }
    
    /**
     * 查询收藏的数量
     * @param type
     * @param id
     * @return
     */
    
    @RequestMapping(value = "/colectCount", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectColectCount(@RequestParam(value="type", required=true) String type,@RequestParam(value="id", required=true) String id){
    	try{
    	int count = service.selectCollectCount(id,type);
		return  new JsonFormat("000000","查询成功",count) ;
    	}catch(Exception de){
    		return new JsonFormat("000003", "服务异常，请重试",null);
    	}
    }
    
    /**
     * 取消收藏
     * @param collectid
     * @return
     */
    
    @RequestMapping(value = "/cancleCollect", method= RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat cancleCollect(@RequestParam(value="collectid", required=true) String collectid){
    	try{
    	int count = service.deleteUserCollectById(collectid);
		return  count>0?new JsonFormat("000000","取消收藏成功",null):new JsonFormat("000001","取消收藏失败",null) ;
    	}catch(Exception de){
    		return new JsonFormat("000003", "服务异常，请重试", null);
    	}
    }
}
