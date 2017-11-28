package com.cpf.mapper.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraProduct;

public interface TraProductMapper {

	List<TraProduct> selectBartersBySearch(@Param("productName") String productName,
			@Param("cateid") String cateid,@Param("ismyself") String ismyself,@Param("era") String era,@Param("sort") String sort
			,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
    int selectBartersBySearchCount(@Param("productName") String productName,
			@Param("cateid") String cateid,@Param("ismyself") String ismyself,@Param("era") String era);
    
    List<SpecialBean> selectSpecialBySearch(@Param("productName") String productName,
			@Param("cateid") String cateid,@Param("ismyself") String ismyself,@Param("era") String era,@Param("sort") String sort
			,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
    
    int selectSpecialBySearchCount(@Param("productName") String productName,
			@Param("cateid") String cateid,@Param("ismyself") String ismyself,@Param("era") String era);
}