package com.cpf.service.transaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.transaction.TraPersonalspecial;

public interface PersonalSpecialidService {
	public List<TraPersonalspecial> selectBestPersonalSpecialid(int beginIndex,int size);
	public List<TraPersonalspecial> findPersonalSpecialList(String specialName,String status,int beginIndex,int endIndex);
	public int findPersonalSpecialListCount(String specialName,String status);
	public TraPersonalspecial selectPersonalById(String zcId);
	public List<TraPersonalspecial> selectPersonalListByUserid(String userInfoId,int beginIndex,int size);
	public int selectPersonalListByUseridCount(String userInfoId);
}
