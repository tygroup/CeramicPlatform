package com.cpf.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.service.transaction.ProductionService;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private TraProductMapper productMapper;

	@Override
	public List<TraProduct> selectBartersBySearch(String productName,String cateid, String ismyself,String era, String sort,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return productMapper.selectBartersBySearch(productName,cateid,ismyself,era,sort, beginIndex, endIndex);
	}

	@Override
	public int selectBartersBySearchCount(String productName,String cateid, String ismyself,String era) {
		// TODO Auto-generated method stub
		return productMapper.selectBartersBySearchCount(productName,cateid,ismyself,era);
	}

	@Override
	public List<SpecialBean> selectSpecialBySearch(String productName,
			String cateid, String ismyself, String era, String sort,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return productMapper.selectSpecialBySearch(productName, cateid, ismyself, era, sort, beginIndex, endIndex);
	}

	@Override
	public int selectSpecialBySearchCount(String productName, String cateid,
			String ismyself, String era) {
		// TODO Auto-generated method stub
		return productMapper.selectSpecialBySearchCount(productName, cateid, ismyself, era);
	} 
	
	
}
