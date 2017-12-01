package com.cpf.service.system;

import java.util.List;
import java.util.Map;

import com.cpf.beans.transaction.TraProduct;

public interface ProductService {
	public TraProduct  insert(TraProduct pro);
	
	public TraProduct  update(TraProduct pro);
	
	public List<TraProduct>  findByUserid(String userid, int beginIndex, int  endIndex);
	
	public int   findByUseridCount(String userid);
	
	public boolean  delete(String productid);
	
	public TraProduct  getByPrimarykey(String productid);
	
	List<TraProduct> selectProductsByUserId( Map<String, Object> params);
}
