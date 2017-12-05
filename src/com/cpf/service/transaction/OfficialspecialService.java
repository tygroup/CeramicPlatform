package com.cpf.service.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraOfficialspecial;

public interface OfficialspecialService {
	public List<TraOfficialspecial> findBestSpecialList(int beginIndex,int size);
	public List<TraOfficialspecial> findOfficialSpecialList(String specialName,String status,int beginIndex,int endIndex);
	public int findOfficialSpecialListCount(String specialName,String status);
	public TraOfficialspecial findOfficialSpecialidById(String zcId);
}
