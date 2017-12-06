package com.cpf.service.impl.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.transaction.TraTrading;
import com.cpf.mapper.transaction.TraTradingMapper;
import com.cpf.service.transaction.TraTradingService;
@Service
@Transactional
public class TraTradingServiceImpl implements TraTradingService{
	@Autowired
	TraTradingMapper tradmap;
	@Override
	public TraTrading save(TraTrading uu) {
		 tradmap.save(uu);
		 return uu;
	}

}
