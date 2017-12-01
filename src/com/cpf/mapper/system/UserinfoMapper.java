package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.Userinfo;

public interface UserinfoMapper {
    
	List<Userinfo> findBestShopList(@Param("count") int count);
	List<Userinfo> findShopInfoById(@Param("userId") String userId);
}