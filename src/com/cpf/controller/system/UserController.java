package com.cpf.controller.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.system.Users;
import com.cpf.beans.transaction.TraCategories;
import com.cpf.service.system.UsersService;
import com.cpf.service.transaction.CategoriesService;
import com.cpf.util.JsonFormat;

/**
 * 种类管理模块--查询种类
 * @author jll
 * @date 2017-11-27 
 */
@RestController
@RequestMapping("users")
@Scope("prototype")
public class UserController {
	@Autowired
	private UsersService usersService;
	
	/**
	 * 查询首页上面的分类
	 * @return
	 */
    @RequestMapping(value = "/login", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat login(@RequestParam(value="account", required=false) String account,@RequestParam(value="password", required=false) String password){
    	
        Users users = usersService.login(account, password);
        return users!=null?new JsonFormat("000000","查询成功",users):new JsonFormat("000001","无数据",users);
    }
    
    
    
}
