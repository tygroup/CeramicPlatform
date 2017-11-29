package com.cpf.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;

import com.cpf.beans.system.Users;
import com.cpf.mapper.system.UsersMapper;
import com.cpf.service.system.UsersService;

public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usermap;
	@Override
	public Users login(String account, String password) {
		return usermap.login(account, password);
	}

	@Override
	public Users regester(String account, String password) {
		return usermap.regester(account, password);
	}

}
