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
import com.cpf.service.transaction.OfficialspecialService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;

/**
 * 官方专场管理类
 * @author jll
 *2017-11-29
 */
@RestController
@RequestMapping("officialspecial")
@Scope("prototype")
public class OfficialspecialController {

	@Resource
	private OfficialspecialService officialspecialService;
	
	/**
	 * 查询官方精品专场
	 * @param count
	 * @return
	 */
	 @RequestMapping(value = "/getBestSpecialList", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
	 @ResponseBody
	 public JsonFormat selectBestSpecialList(@RequestParam(value="count", required=true) String count){
		 if(Validators.isNumeric(count)){
			 int icount = Integer.parseInt(count);
			  List<TraOfficialspecial> bestOfficialSpecial = officialspecialService.findBestSpecialList(icount);
		        return bestOfficialSpecial!=null&&bestOfficialSpecial.size()>0?new JsonFormat("000000","查询成功",bestOfficialSpecial):new JsonFormat("000001","无数据",null);
		 }else{
			 return new JsonFormat("000002","参数错误",null);
		 }
	      
	   }
	 
		/**
		 * 查询官方专场分页
		 * @param count
		 * @return
		 */
		 @RequestMapping(value = "/getOfficialSpecialList", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
		 @ResponseBody
		 public JsonFormat findOfficialSpecialList(@RequestParam(value="specialName", required=false) String specialName,@RequestParam(value="status", required=false) String status,
				 @RequestParam(value="cpage", required=true) String cpage,
				 @RequestParam(value="pageSize", required=true) String pageSize){
			 if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
				  int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
		          int endIndex = Integer.parseInt(cpage)*Integer.parseInt(pageSize);
				  List<TraOfficialspecial> OfficialSpecials = officialspecialService.findOfficialSpecialList(specialName,status, beginIndex, endIndex);
				  int totalCount = officialspecialService.findOfficialSpecialListCount(specialName, status);
			      return OfficialSpecials!=null&&OfficialSpecials.size()>0?new JsonFormat("000000","查询成功",totalCount,OfficialSpecials):new JsonFormat("000001","无数据",0,null);
			 }else{
				 return new JsonFormat("000002","参数错误",null);
			 }
		      
		   }
}
