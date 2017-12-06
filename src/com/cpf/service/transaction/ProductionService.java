package com.cpf.service.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraBidrecord;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.beans.transaction.TraProductFiles;
import com.cpf.beans.transaction.TraTrading;

public interface ProductionService {
	public List<TraProduct> selectBartersBySearch(String productName,String cateid, String ismyself,String era, String sort,
			int beginIndex, int endIndex);
	public int selectBartersBySearchCount(String productName,String cateid, String ismyself,String era);
	
	public List<SpecialBean> selectSpecialBySearch(String productName,
			String cateid,String ismyself,String era,String sort
			,int beginIndex,int endIndex);
    
    public int selectSpecialBySearchCount(String productName,
			String cateid,String ismyself,String era);
    
    public List<SpecialBean> selectHotSpecialid(int beginIndex,int size);
    public List<TraProduct> selectHotBarters(int beginIndex,int size);
    
    public List<TraTrading> findProductionById(String productId);
    
    public List<TraBidrecord> selectBidRecordByProductId(String productId,int beginIndex,int size);
    
    public int selectBidRecordByProductIdCount(String productId);
    
    public List<TraTrading> findProductionByZcId(String zcId,int beginIndex,int size);
    public int findProductionByZcIdCount(String zcId);
    
    public List<TraProductFiles> selectPicByProductionId(String productId);
    
	public List<TraTrading> selectBartersByUserInfoId( String userInfoId,int beginIndex,int size);
	public int selectBartersByUserInfoIdCount(String userInfoId);
}
