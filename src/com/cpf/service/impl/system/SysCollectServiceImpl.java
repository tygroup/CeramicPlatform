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

}
