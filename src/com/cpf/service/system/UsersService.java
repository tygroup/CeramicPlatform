package com.cpf.service.system;

import com.cpf.beans.system.Users;

public interface UsersService {
	public  Users login(String account,String password);
	public  Users regester(String account,String password);
}
