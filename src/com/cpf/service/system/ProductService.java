package com.cpf.service.system;

import java.util.List;
import java.util.Map;

import com.cpf.beans.transaction.TraProduct;

public interface ProductService {
	public TraProduct  insert(TraProduct pro);
	
	public TraProduct  update(TraProduct pro);
	
	public boolean  delete(String productid);
	
	public TraProduct  getByPrimarykey(String productid);
	
	List<TraProduct> selectProductsByUserId( Map<String, Object> params);
	
	public int   findByUseridCount(Map<String, Object> params);
	
	List<TraProduct> selectProductsByUserIdforSJ( Map<String, Object> params);
	
	public int   selectProductsByUseridCountforSJ(Map<String, Object> params);
}
