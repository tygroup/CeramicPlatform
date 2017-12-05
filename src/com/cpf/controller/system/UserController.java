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
 * 用户基本信息 登录 注册
 * @author jml
 * @date 2017-11-30 
 */
@RestController
@RequestMapping("users")
@Scope("prototype")
public class UserController {
	@Autowired
	private UsersService usersService;
	
	/**
	 * 登录
	 * @return
	 */
    @RequestMapping(value = "/login", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat login(@RequestParam(value="phonenum", required=false) String phonenum,@RequestParam(value="password", required=false) String password){
    	
        Users users = usersService.login(phonenum, password);
        return users!=null?new JsonFormat("000000","查询成功",users):new JsonFormat("000001","无数据",users);
    }
    
    /**
	 * 获取用户信息
	 * @return
	 */
    @RequestMapping(value = "/usersMsg", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat getUsersMsg(@RequestParam(value="userid", required=false) String userid){
    	
        Users users = usersService.getUsersMsg(userid);
        return users!=null?new JsonFormat("000000","查询成功",users):new JsonFormat("000001","无数据",users);
    }
    
    /**
	 * 注册
	 * @return
	 */
    @RequestMapping(value = "/regester", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat regester(@RequestParam(value="phonenum", required=false) String phonenum,@RequestParam(value="password", required=false) String password){
    	
        Users users = new Users();
	        users.setPhonenum(phonenum);
	        users.setPassword(password);
	        users = usersService.regester(users);
        return users!=null?new JsonFormat("000000","查询成功",users):new JsonFormat("000001","无数据",users);
    }
    
    
    
    
}
