package com.cpf.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.transaction.OrderBean;
import com.cpf.mapper.transaction.TraSpecialordersMapper;
import com.cpf.service.transaction.SpecialOrdersService;

@Service("specialOrdersService")
public class SpecialOrdersServiceImpl implements SpecialOrdersService {

	@Autowired
	private TraSpecialordersMapper specialordersMapper;

	@Override
	public List<OrderBean> findlatestOrderokList() {
		// TODO Auto-generated method stub
		return specialordersMapper.findlatestOrderokList();
	}
	
}
