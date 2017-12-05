package com.cpf.service.impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.system.SysCollect;
import com.cpf.mapper.system.SysCollectMapper;
import com.cpf.service.system.SysCollectService;
@Service
@Transactional
public class SysCollectServiceImpl implements SysCollectService {
	@Autowired
	SysCollectMapper conmap;
	@Override
	public List<SysCollect> findByUserid(String type, String userid,
			int beginIndex, int endIndex) {
		return conmap.findByUserid(type, userid, beginIndex, endIndex);
	}
	@Override
	public int findByUseridCount(String type, String userid) {
		return conmap.findByUseridCount(type, userid);
	}
	@Override
	public String saveCollect(SysCollect collect) {
		// TODO Auto-generated method stub
		int count = conmap.saveCollect(collect);
		return collect.getCollectid();
	}
	@Override
	public List<SysCollect> selectCollectInfo(String id, String type,String userId) {
		// TODO Auto-generated method stub
		return conmap.selectCollectInfo(id, type,userId);
	}
	@Override
	public int selectCollectCount(String id, String type) {
		// TODO Auto-generated method stub
		return conmap.selectCollectCount(id, type);
	}
	@Override
	public int deleteUserCollectById(String collectid) {
		// TODO Auto-generated method stub
		return conmap.deleteUserCollectById(collectid);
	}

}
