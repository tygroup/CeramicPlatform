package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.Userinfo;
import com.cpf.mapper.BaseMapper;

public interface UserinfoMapper extends BaseMapper<Userinfo, String>{
    
	List<Userinfo> findBestShopList(@Param("beginIndex") int beginIndex,@Param("size") int size);
	List<Userinfo> findShopInfoById(@Param("userId") String userId);
	List<Userinfo> selectShopList(@Param("sort") String sort,@Param("beginIndex") int beginIndex,@Param("size") int size);

	int selectShopListCount(@Param("sort") String sort);

}
