package com.cpf.service.impl.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.transaction.TraProduct;
import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.service.system.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{
	@Autowired
	private TraProductMapper productMapper;
	@Override
	public TraProduct insert(TraProduct pro) {
		return productMapper.save(pro);
	}

	@Override
	public TraProduct update(TraProduct pro) {
		  productMapper.update(pro);
		  return pro;
	}

	@Override
	public List<TraProduct> findByUserid(String userid, int beginIndex,
			int endIndex) {
		return productMapper.findByUserid(userid, beginIndex, endIndex);
	}

	@Override
	public int findByUseridCount(String userid) {
		return productMapper.findByUseridCount(userid);
	}

	@Override
	public boolean delete(String productid) {
		 productMapper.delete(TraProduct.class, productid);
		 return true;
	}

	@Override
	public TraProduct getByPrimarykey(String productid) {
		return productMapper.findById(productid);
	}

	@Override
	public List<TraProduct> selectProductsByUserId(Map<String, Object> params) {
		
		return productMapper.selectProductsByUserId(params);
	}

}
