package com.cpf.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cpf.beans.system.SysCollect;
import com.cpf.mapper.BaseMapper;

public interface SysCollectMapper  extends BaseMapper<SysCollect, String>{
	public List<SysCollect> findByUserid(@Param("type")String type, @Param("userid")String userid,
			@Param("beginIndex")int beginIndex, @Param("endIndex")int endIndex);
	
	public int  findByUseridCount(String type,String userid);
}