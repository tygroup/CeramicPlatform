package com.cpf.service.system;

import java.util.List;

import com.cpf.beans.system.SysCollect;

public interface SysCollectService {
	public List<SysCollect>  findByUserid(String type,String userid, int beginIndex, int  endIndex);
	public int  findByUseridCount(String type,String userid);
}
