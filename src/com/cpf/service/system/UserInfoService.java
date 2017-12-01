package com.cpf.service.system;

import java.util.List;

import com.cpf.beans.system.Userinfo;

public interface UserInfoService {
	List<Userinfo> findBestShopList(int count);
}
