package com.cpf.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("products")
@Scope("prototype")
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	/**
	 * 添加/编辑 商品 
	 * @return
	 */
    @RequestMapping(value = "/manageProducts", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat manageProducts(@RequestParam(value="msg", required=false) String msg){
    	
    	JSONObject jsonObject=JSONObject.fromObject(msg);
    	
    	TraProduct product = (TraProduct) jsonObject.toBean(jsonObject,TraProduct.class);
    	
    	if(product!=null && product.getProductid()!=null){
    		
    		product= service.insert(product);
    	}else{
    		product= service.update(product);
    	}
    	
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
    
    /**
	 * 根据id查询 商品 
	 * @return
	 */
    @RequestMapping(value = "/findProductsById", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat findProductsById(@RequestParam(value="productId", required=false) String productId){
    	TraProduct	product=null;
    	
    	if(productId!=null && !productId.equals("")){
    		
    		 	product= service.getByPrimarykey(productId);
    	}
        return product!=null?new JsonFormat("000000","查询成功",product):new JsonFormat("000001","无数据",product);
    }
    
    /**
   	 * 根据Userid查询易物/拍卖商品 
   	 * toUsed 0拍卖1易物
   	 * @return
   	 */
    @RequestMapping(value = "/findProductsListById", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat findByUserId(@RequestParam(value="toUsed", required=false) String toUsed,@RequestParam(value="userId", required=false) String userId){
       	Map<String ,Object> map = new HashMap<String, Object>();
    	  map.put("toUsed", toUsed);
    	  map.put("userId", userId);
    	  
       List<TraProduct> list = 	service.selectProductsByUserId(map);
    	   
    	   return list!=null?new JsonFormat("000000","查询成功",list):new JsonFormat("000001","无数据",list);
       }
       
    
}
