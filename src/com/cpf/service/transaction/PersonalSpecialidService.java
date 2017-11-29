package com.cpf.service.transaction;

import java.util.List;

import com.cpf.beans.transaction.TraPersonalspecial;

public interface PersonalSpecialidService {
	public List<TraPersonalspecial> selectBestPersonalSpecialid(int count);
	public List<TraPersonalspecial> findPersonalSpecialList(String specialName,String status,int beginIndex,int endIndex);
	public int findPersonalSpecialListCount(String specialName,String status);
}
