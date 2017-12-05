package com.cpf.controller.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.transaction.TraOfficialspecial;
import com.cpf.beans.transaction.TraPersonalspecial;
import com.cpf.service.transaction.PersonalSpecialidService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;
/**
 * 个人专场管理类
 * @author jll
 * 2017-11-29
 */

@RestController
@RequestMapping("personalSpecialid")
@Scope("prototype")
public class PersonalSpecialidController {

	@Resource
	private PersonalSpecialidService persionalSpecialidService;
	
	/**
	 * 查询个人精品专场
	 * @param count
	 * @return
	 */
	
	 @RequestMapping(value = "/getBestPersionSpecialidList", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	 @ResponseBody
	 public JsonFormat selectBestPersionSpecialidList(@RequestParam(value="cpage", required=true) String cpage,@RequestParam(value="pageSize", required=true) String pageSize){
		 if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
			  int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
	          int size = Integer.parseInt(pageSize);
			  List<TraPersonalspecial> bestOfficialSpecial = persionalSpecialidService.selectBestPersonalSpecialid(beginIndex,size);
		        return bestOfficialSpecial!=null&&bestOfficialSpecial.size()>0?new JsonFormat("000000","查询成功",bestOfficialSpecial):new JsonFormat("000001","无数据",null);
		 }else{
			 return new JsonFormat("000002","参数错误",null);
		 }
	      
	   }
	 
	 
	 /**
		 * 查询个人专场分页
		 * @param count
		 * @return
		 */
		 @RequestMapping(value = "/getPersonalSpecialList", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
		 @ResponseBody
		 public JsonFormat PersonalSpecialList(@RequestParam(value="specialName", required=false) String specialName,@RequestParam(value="status", required=false) String status,
				 @RequestParam(value="cpage", required=true) String cpage,
				 @RequestParam(value="pageSize", required=true) String pageSize){
			 if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
				  int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
		          int endIndex = Integer.parseInt(pageSize);
				  List<TraPersonalspecial> OfficialSpecials = persionalSpecialidService.findPersonalSpecialList(specialName, status, beginIndex, endIndex);
				  int totalCount = persionalSpecialidService.findPersonalSpecialListCount(specialName, status);
			      return OfficialSpecials!=null&&OfficialSpecials.size()>0?new JsonFormat("000000","查询成功",totalCount,OfficialSpecials):new JsonFormat("000001","无数据",0,null);
			 }else{
				 return new JsonFormat("000002","参数错误",null);
			 }
		      
		   }
		 
		 
		 /**
		  * 根据zcid查询官方专场的详细信息
		  * @param zcId
		  * @return
		  */
		 @RequestMapping(value = "/personnalInfo", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
		 @ResponseBody
		 public JsonFormat selectPersonnalInfo(@RequestParam(value="zcId", required=true) String zcId){
			TraPersonalspecial personalSpecials = persionalSpecialidService.selectPersonalById(zcId);
		    return personalSpecials!=null?new JsonFormat("000000","查询成功",personalSpecials):new JsonFormat("000001","无数据",null);
		      
		   }
		 
		 /**
		  * 根据店铺的userid查询专场列表
		  * @param zcId
		  * @return
		  */
		 @RequestMapping(value = "/personalsOfUser", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
		 @ResponseBody
		 public JsonFormat selectPersonalsOfUser(@RequestParam(value="userInfoId", required=true) String userInfoId,@RequestParam(value="cpage", required=true) String cpage,@RequestParam(value="pageSize", required=true) String pageSize){
			 if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
				  int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
		          int size = Integer.parseInt(pageSize);
		          List<TraPersonalspecial> personalSpecials = persionalSpecialidService.selectPersonalListByUserid(userInfoId, beginIndex, size);
		          int totalCount = persionalSpecialidService.selectPersonalListByUseridCount(userInfoId);
		          return personalSpecials!=null?new JsonFormat("000000","查询成功",totalCount,personalSpecials):new JsonFormat("000001","无数据",totalCount,null);
			 }else{
				 return new JsonFormat("000002","参数错误",null);
			 }
		   }
		 
}
