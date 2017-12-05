package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.SysCollect;
import com.cpf.mapper.BaseMapper;

public interface SysCollectMapper  extends BaseMapper<SysCollect, String>{
	public List<SysCollect> findByUserid(@Param("type")String type, @Param("userid")String userid,
			@Param("beginIndex")int beginIndex, @Param("endIndex")int endIndex);
	
	public int  findByUseridCount(String type,String userid);
	
	int saveCollect(SysCollect collect);
	List<SysCollect> selectCollectInfo(@Param("id") String id,@Param("type") String type,@Param("userId") String userId);
	int selectCollectCount(@Param("id") String id,@Param("type") String type);
	int deleteUserCollectById(@Param("collectid") String collectid);
}