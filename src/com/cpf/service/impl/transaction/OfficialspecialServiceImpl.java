package com.cpf.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.transaction.TraOfficialspecial;
import com.cpf.mapper.transaction.TraOfficialspecialMapper;
import com.cpf.service.transaction.OfficialspecialService;

@Service("officialspecialService")
public class OfficialspecialServiceImpl implements OfficialspecialService {

	@Autowired
	private TraOfficialspecialMapper officialspecialMapper;

	@Override
	public List<TraOfficialspecial> findBestSpecialList(int count) {
		// TODO Auto-generated method stub
		return officialspecialMapper.findBestSpecialList(count);
	}

	@Override
	public List<TraOfficialspecial> findOfficialSpecialList(String specialName,String status,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return officialspecialMapper.findOfficialSpecialList(specialName,status, beginIndex, endIndex);
	}

	@Override
	public int findOfficialSpecialListCount(String specialName, String status) {
		// TODO Auto-generated method stub
		return officialspecialMapper.findOfficialSpecialListCount(specialName, status);
	}

	@Override
	public List<TraOfficialspecial> findOfficialSpecialidById(String zcId) {
		// TODO Auto-generated method stub
		return officialspecialMapper.findOfficialSpecialidById(zcId);
	}
	
	
}
