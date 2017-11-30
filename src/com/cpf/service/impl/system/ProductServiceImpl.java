package com.cpf.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.transaction.TraProduct;
import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.service.system.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	TraProductMapper promap;
	@Override
	public TraProduct insert(TraProduct pro) {
		return promap.insert(pro);
	}

	@Override
	public TraProduct update(TraProduct pro) {
		return promap.update(pro);
	}

	@Override
	public List<TraProduct> findByUserid(String userid,int beginIndex,int  endIndex) {
		return promap.findByUserid(userid, beginIndex, endIndex);
	}

	@Override
	public boolean delete(String productid) {
		return promap.delete(productid);
	}

	@Override
	public TraProduct getByPrimarykey(String productid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findByUseridCount(String userid) {
		// TODO Auto-generated method stub
		return promap.findByUseridCount(userid);
	}

}
