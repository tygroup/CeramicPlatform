package com.cpf.service.imp.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.system.Userinfo;
import com.cpf.mapper.system.UserinfoMapper;
import com.cpf.service.system.UserInfoService;

@Service("userInfoService1")
public class UserInfoServiceImpl  {
	private UserinfoMapper userInfoMapper;
	public List<Userinfo> findBestShopList(int beginIndex,int size) {
		// TODO Auto-generated method stub
		return userInfoMapper.findBestShopList(beginIndex,size);
	}


	public List<Userinfo> findShopInfoById(String userId) {
		// TODO Auto-generated method stub
		return userInfoMapper.findShopInfoById(userId);
	}


	public List<Userinfo> selectShopList(String sort, int beginIndex, int size) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectShopList(sort, beginIndex, size);
	}
	
}
