package com.cpf.controller.system;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.Users;
import com.cpf.beans.transaction.TraPersonalspecial;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.service.system.ProductService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;
/**
 * 用户中心--商品管理
 * @author jml
 * @date 2017-11-30
 */
@RestController
@RequestMapping("users")
@Scope("prototype")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	/**
	 * 添加商品
	 * @return
	 */
    @RequestMapping(value = "/insertProduct", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat insertProduct(@RequestParam(value="msg", required=false) String msg){
    	
    	JSONObject jsonObject=JSONObject.fromObject(msg);
    	
    	TraProduct product = (TraProduct) jsonObject.toBean(jsonObject,TraProduct.class);
    	
    	product= service.insert(product);
        return product!=null?new JsonFormat("000000","查询成功",product):new JsonFormat("000001","无数据",product);
    }
    /**
	 * 查看商品列表
	 * @return
	 */
    @RequestMapping(value = "/findProductByUserId", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat findProductByUserId(@RequestParam(value="userId", required=true) String userId,@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
            int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int endIndex = Integer.parseInt(cpage)*Integer.parseInt(pageSize);
            List<TraProduct> OfficialSpecials = service.findByUserid(userId, beginIndex, endIndex);
			  int totalCount = service.findByUseridCount(userId);
		      return OfficialSpecials!=null&&OfficialSpecials.size()>0?new JsonFormat("000000","查询成功",totalCount,OfficialSpecials):new JsonFormat("000001","无数据",0,null);
		 }else{
			 return new JsonFormat("000002","参数错误",null);
		 }
    }
}
