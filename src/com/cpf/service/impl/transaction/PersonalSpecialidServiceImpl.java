package com.cpf.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.transaction.TraPersonalspecial;
import com.cpf.mapper.transaction.TraPersonalspecialMapper;
import com.cpf.service.transaction.PersonalSpecialidService;

@Service("persionalSpecialidService")
public class PersonalSpecialidServiceImpl implements PersonalSpecialidService {

	@Autowired
	private TraPersonalspecialMapper personalspecialMapper;

	@Override
	public List<TraPersonalspecial> selectBestPersonalSpecialid(int count) {
		// TODO Auto-generated method stub
		return personalspecialMapper.selectBestPersonalSpecialid(count);
	}

	@Override
	public List<TraPersonalspecial> findPersonalSpecialList(String specialName,
			String status, int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return personalspecialMapper.findPersonalSpecialList(specialName, status, beginIndex, endIndex);
	}

	@Override
	public int findPersonalSpecialListCount(String specialName, String status) {
		// TODO Auto-generated method stub
		return personalspecialMapper.findPersonalSpecialListCount(specialName, status);
	}

	@Override
	public List<TraPersonalspecial> selectPersonalById(String zcId) {
		// TODO Auto-generated method stub
		return personalspecialMapper.selectPersonalById(zcId);
	}
	
}
