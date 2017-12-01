package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraTrading;
import com.cpf.mapper.BaseMapper;

public interface TraTradingMapper extends BaseMapper<TraTrading, String>{

	List<TraTrading> findProductionById(@Param("productId") String productId);
}