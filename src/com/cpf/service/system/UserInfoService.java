package com.cpf.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.Userinfo;

public interface UserInfoService {
	public List<Userinfo> findBestShopList(int beginIndex,int size);
	public List<Userinfo> findShopInfoById(String userId);
	public List<Userinfo> selectShopList(String sort,int beginIndex,int size);
	public int selectShopListCount(String sort);
}
