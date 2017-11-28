package com.cpf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.Test;
import com.cpf.dao.TestMapper;
import com.cpf.service.TestService;


@Service
@Transactional
public class TestServiceImpl implements TestService {
	 @Autowired
	private TestMapper dao;
	@Override
	public List getAll() {
		return dao.selectAll();
	}
	@Override
	public void insert(Test t) {
		dao.insert(t);
		
	}

}
