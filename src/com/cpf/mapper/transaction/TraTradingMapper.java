package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraTrading;
import com.cpf.mapper.BaseMapper;

public interface TraTradingMapper extends BaseMapper<TraTrading, String>{

	List<TraTrading> findProductionById(@Param("productId") String productId);
	List<TraTrading> findProductionByZcId(@Param("zcId")String zcId,@Param("beginIndex") int beginIndex,@Param("size") int size);
	int findProductionByZcIdCount(@Param("zcId") String zcId);
	
	List<TraTrading> selectBartersByUserInfoId(@Param("userInfoId") String userInfoId,@Param("beginIndex") int beginIndex,@Param("size") int size);
	int selectBartersByUserInfoIdCount(@Param("userInfoId") String userInfoId);
}