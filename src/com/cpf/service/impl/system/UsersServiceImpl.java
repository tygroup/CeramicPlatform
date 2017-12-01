package com.cpf.service.impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.system.Useramount;
import com.cpf.beans.system.Users;
import com.cpf.mapper.system.UseramountMapper;
import com.cpf.mapper.system.UsersMapper;
import com.cpf.service.system.UsersService;
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usermap;
	@Autowired
	UseramountMapper amountmap;
	@Override
	public Users login(String phonenum, String password) {
		return usermap.login(phonenum, password);
	}

	@Override
	public Users regester(Users uu) {
		  usermap.regester(uu);
		  
		  Useramount amount = new Useramount();
		  	amount.setUserid(uu.getUserid());
		  	amount.setAvailablebalance(0.0);
		  	amount.setBalance(0.0);
		  	amount.setMargin(0.0);
		  	amount.setIsmargin("0");
		  	amount.setKymargin(0.0);
		  	amount.setUserlevel("0");
		  amountmap.save(amount);
		 return uu;
	}

	@Override
	public Users getUsersMsg(String userid) {
		return usermap.findUserMsg(userid);
	}

}
