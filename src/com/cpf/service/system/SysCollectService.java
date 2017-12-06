package com.cpf.service.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.SysCollect;

public interface SysCollectService {
	public List<SysCollect>  findByUserid(String type,String userid, int beginIndex, int  endIndex);
	public int  findByUseridCount(String type,String userid);
	public String  saveCollect(SysCollect collect);
	public List<SysCollect> selectCollectInfo(String id,String type,String userId);
	public int selectCollectCount(String id,String type);
	public int deleteUserCollectById(String collectid);
  
}
