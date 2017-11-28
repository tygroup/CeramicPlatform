package com.cpf.controller.transaction;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cpf.service.transaction.ProductionService;


/**
 * 商品管理模块 
 * @author jll
 *	2017-11-28
 */
@RestController
@RequestMapping("specialorder")
@Scope("prototype")
public class ProductionController {

	@Resource
	private ProductionService productionService;
	
	
}
