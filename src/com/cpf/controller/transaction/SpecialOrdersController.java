package com.cpf.controller.transaction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.beans.transaction.OrderBean;
import com.cpf.service.transaction.SpecialOrdersService;
import com.cpf.util.JsonFormat;

/**
 * 拍卖订单管理类
 * @author jll
 *2017-11-27
 */
@RestController
@RequestMapping("specialorder")
@Scope("prototype")
public class SpecialOrdersController {

	@Resource
	private  SpecialOrdersService specialOrdersService;
	
	/**
	 * 查询首页上面拍卖成功消息
	 * @return
	 */
    @RequestMapping(value = "/getLatestspecialorder", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonFormat selectLatestspecialorder(){
        List<OrderBean> orderMessage = specialOrdersService.findlatestOrderokList();
        return orderMessage!=null&&orderMessage.size()>0?new JsonFormat("000000","查询成功",orderMessage):new JsonFormat("000001","无数据",orderMessage);
    }
    
    
	
}
