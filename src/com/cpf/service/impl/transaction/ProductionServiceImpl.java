package com.cpf.service.impl.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.service.transaction.ProductionService;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private TraProductMapper productMapper; 
}
