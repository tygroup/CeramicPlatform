package com.cpf.service.system;

import com.cpf.beans.system.Users;

public interface UsersService {
	public  Users login(String phonenum,String password);
	
	public  Users regester(Users uu);
	
	public Users getUsersMsg(String userid);
}
