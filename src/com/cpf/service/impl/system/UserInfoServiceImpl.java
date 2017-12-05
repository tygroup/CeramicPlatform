package com.cpf.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.system.Userinfo;
import com.cpf.mapper.system.UserinfoMapper;
import com.cpf.service.system.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserinfoMapper userInfoMapper;

	@Override
	public List<Userinfo> findBestShopList(int beginIndex,int size) {
		// TODO Auto-generated method stub
		return userInfoMapper.findBestShopList(beginIndex,size);
	}

	@Override
	public List<Userinfo> findShopInfoById(String userId) {
		// TODO Auto-generated method stub
		return userInfoMapper.findShopInfoById(userId);
	}

	@Override
	public List<Userinfo> selectShopList(String sort, int beginIndex, int size) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectShopList(sort, beginIndex, size);
	}

	@Override
	public int selectShopListCount(String sort) {
		// TODO Auto-generated method stub
		return userInfoMapper.selectShopListCount(sort);
	}
	
}
