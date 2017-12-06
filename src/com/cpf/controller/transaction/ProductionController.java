package com.cpf.controller.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraBidrecord;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.beans.transaction.TraProductFiles;
import com.cpf.beans.transaction.TraTrading;
import com.cpf.service.transaction.ProductionService;
import com.cpf.util.JsonFormat;
import com.cpf.util.Validators;


/**
 * 商品管理模块 
 * @author jll
 *	2017-11-28
 */
@RestController
@RequestMapping("production")
@Scope("prototype")
public class ProductionController {

	@Resource
	private ProductionService productionService;
	
	 
	/**
	 * 查询首页上面搜索易物接口
	 * @param productName 搜索内容
	 * @param cateid 分类
	 * @param ismyself 来源
	 * @param era 年代
	 * @param sort 排序 0 时间1收藏
	 * @param cpage
	 * @param pageSize
	 * @return
	 */
    @RequestMapping(value = "/getBartersBySearch", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectBartersBySearch(@RequestParam(value="productName", required=false) String productName,
    		@RequestParam(value="cateid", required=false) String cateid,
    		@RequestParam(value="ismyself", required=false) String ismyself,
    		@RequestParam(value="era", required=false) String era,
    		@RequestParam(value="sort", required=false) String sort,
    		@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
            int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int endIndex =Integer.parseInt(pageSize);
            List<TraProduct> barters = productionService.selectBartersBySearch(productName,cateid,ismyself,era,sort, beginIndex, endIndex);
            int totalCount = productionService.selectBartersBySearchCount(productName,cateid,ismyself,era);
            return barters!=null&&barters.size()>0?new JsonFormat("000000","查询成功",totalCount,barters):new JsonFormat("000001","无数据",0,barters);
        
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
            }
        }
    
    
    /**
     * 拍卖品种列表 分页
     * @param productName
     * @param cateid
     * @param ismyself
     * @param era
     * @param sort
     * @param cpage
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/getSpecialBySearch", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectSpecialBySearch(@RequestParam(value="productName", required=false) String productName,
    		@RequestParam(value="cateid", required=false) String cateid,
    		@RequestParam(value="ismyself", required=false) String ismyself,
    		@RequestParam(value="era", required=false) String era,
    		@RequestParam(value="sort", required=false) String sort,
    		@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
            int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int endIndex = Integer.parseInt(pageSize);
            List<SpecialBean> barters = productionService.selectSpecialBySearch(productName, cateid, ismyself, era, sort, beginIndex, endIndex);
            int totalCount = productionService.selectSpecialBySearchCount(productName, cateid, ismyself, era);
            return barters!=null&&barters.size()>0?new JsonFormat("000000","查询成功",totalCount,barters):new JsonFormat("000001","无数据",0,barters);
        
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
            }
        }
    
    /**
     * 查询热门拍品
     * @param count
     * @return
     */
    @RequestMapping(value = "/getHotSpecialid", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectHotSpecialid(@RequestParam(value="cpage", required=true) String cpage,@RequestParam(value="pageSize", required=true) String pageSize){
    	
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
    		 int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
             int size = Integer.parseInt(pageSize);
    		List<SpecialBean> hotSpecialid = productionService.selectHotSpecialid(beginIndex,size);
    		return hotSpecialid!=null&&hotSpecialid.size()>0?new JsonFormat("000000","查询成功",hotSpecialid):new JsonFormat("000001","无数据",null);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
    /**
     * 查询热门易物
     * @param count
     * @return
     */
    @RequestMapping(value = "/getHotBarters", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectHotBarters(@RequestParam(value="cpage", required=true) String cpage,@RequestParam(value="pageSize", required=true) String pageSize){
    	
    	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
   		 int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
            int size = Integer.parseInt(pageSize);
    		List<TraProduct> hotSpecialid = productionService.selectHotBarters(beginIndex,size);
    		return hotSpecialid!=null&&hotSpecialid.size()>0?new JsonFormat("000000","查询成功",hotSpecialid):new JsonFormat("000001","无数据",null);
    	}else{
    		return new JsonFormat("000002","参数错误",null);	
    	}
    }
    
    
 
    /**
     * 查询商品详情根据id
     * @param productId
     * @return
     */
    @RequestMapping(value = "/productionInfo", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectProductionInfoById(@RequestParam(value="productId", required=true) String productId){
    	List<TraTrading> productInfo =productionService.findProductionById(productId);
    	return productInfo!=null&&productInfo.size()>0?new JsonFormat("000000", "查询成功", productInfo):new JsonFormat("000001", "无数据", null);
    	 
    }
    
    /**
     * 查询拍品的出价记录  根据productId
     * @param productId
     * @author jll
     * @date 2017-12-01
     */
    
    @RequestMapping(value = "/bidrecords", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectBidrecords(@RequestParam(value="productId", required=true) String productId,
    		@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
        	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
                int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
                int size = Integer.parseInt(pageSize);
    	List<TraBidrecord> bidrecords =productionService.selectBidRecordByProductId(productId, beginIndex, size);
    	int totalCount = productionService.selectBidRecordByProductIdCount(productId);
    	return bidrecords!=null&&bidrecords.size()>0?new JsonFormat("000000", "查询成功",totalCount, bidrecords):new JsonFormat("000001", "无数据",0, null);
        }else{
        	return new JsonFormat("000002", "参数错误", null);
        }
    }
    
    /**
     * 根据zcid查询专场中的物品
     */
    
    @RequestMapping(value = "/productionsOfZc", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectproductionsOfZc(@RequestParam(value="zcId", required=true) String zcId,
    		@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
        	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
                int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
                int size = Integer.parseInt(pageSize);
    	List<TraTrading> productionsOfZc =productionService.findProductionByZcId(zcId, beginIndex, size);
    	int totalCount = productionService.findProductionByZcIdCount(zcId);
    	return productionsOfZc!=null&&productionsOfZc.size()>0?new JsonFormat("000000", "查询成功",totalCount, productionsOfZc):new JsonFormat("000001", "无数据",0, null);
        }else{
        	return new JsonFormat("000002", "参数错误", null);
        }
    }
    /**
     * 根据productId查询pics
     * @param productId
     * @return
     */
    @RequestMapping(value = "/pics", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectPicsByProductId(@RequestParam(value="productId", required=true) String productId){
    	List<TraProductFiles> pics =productionService.selectPicByProductionId(productId);
    	return pics!=null&&pics.size()>0?new JsonFormat("000000", "查询成功", pics):new JsonFormat("000001", "无数据", null);
    	 
    }
    
    
    @RequestMapping(value = "/bartersOfShop", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectBartersOfShop(@RequestParam(value="userInfoId", required=true) String userInfoId,
    		@RequestParam(value="cpage", required=true) String cpage,
    		@RequestParam(value="pageSize", required=true) String pageSize){
        	if(Validators.isNumeric(cpage)&&Validators.isNumeric(pageSize)){
                int beginIndex = (Integer.parseInt(cpage)-1)*Integer.parseInt(pageSize);
                int size = Integer.parseInt(pageSize);
    	List<TraTrading> productionsOfZc =productionService.selectBartersByUserInfoId(userInfoId, beginIndex, size);
    	int totalCount = productionService.selectBartersByUserInfoIdCount(userInfoId);
    	return productionsOfZc!=null&&productionsOfZc.size()>0?new JsonFormat("000000", "查询成功",totalCount, productionsOfZc):new JsonFormat("000001", "无数据",0, null);
        }else{
        	return new JsonFormat("000002", "参数错误", null);
        }
    }
    
 
}
