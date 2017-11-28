package com.cpf.service.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraProduct;

public interface ProductionService {
	public List<TraProduct> selectBartersBySearch(String productName,String cateid, String ismyself,String era, String sort,
			int beginIndex, int endIndex);
	public int selectBartersBySearchCount(String productName,String cateid, String ismyself,String era);
	
	public List<SpecialBean> selectSpecialBySearch(String productName,
			String cateid,String ismyself,String era,String sort
			,int beginIndex,int endIndex);
    
    public int selectSpecialBySearchCount(String productName,
			String cateid,String ismyself,String era);
}
