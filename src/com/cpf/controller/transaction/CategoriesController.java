package com.cpf.controller.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.transaction.TraCategories;
import com.cpf.service.transaction.CategoriesService;
import com.cpf.util.JsonFormat;

/**
 * 种类管理模块--查询种类
 * @author jll
 * @date 2017-11-27 
 */
@RestController
@RequestMapping("category")
@Scope("prototype")
public class CategoriesController {
	@Resource
	private CategoriesService categoriesService;
	
	/**
	 * 查询首页上面的分类
	 * @return
	 */
    @RequestMapping(value = "/categories", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectUserById(){
        List<TraCategories> categories = categoriesService.findCategories();
        return categories!=null&&categories.size()>0?new JsonFormat("000000","查询成功",categories):new JsonFormat("000001","无数据",categories);
    }
    
    
    
}
