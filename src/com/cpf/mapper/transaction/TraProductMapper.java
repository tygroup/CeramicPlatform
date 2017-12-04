package com.cpf.mapper.transaction;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.mapper.BaseMapper;

public interface TraProductMapper extends BaseMapper<TraProduct, String>{

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
    
    List<SpecialBean> selectHotSpecialid(@Param("beginIndex") int beginIndex,@Param("size") int size);
    List<TraProduct> selectHotBarters(@Param("beginIndex") int beginIndex,@Param("size") int size);
    
   
    TraProduct findByPrimarykey(String productid);
    
    List<TraProduct> findByUserid(@Param("userid")String userid,@Param("beginIndex") int beginIndex,@Param("endIndex") int endIndex);
    
    int  findByUseridCount(@Param("userid")String userid);
    
    boolean delete(String productid);
    
    List<TraProduct>  selectProductsByUserId(@Param("map")Map<String, Object> params);
    
}