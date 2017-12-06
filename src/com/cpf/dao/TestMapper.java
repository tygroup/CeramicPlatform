package com.cpf.dao;

import java.util.List;

import com.cpf.beans.Test;

public interface TestMapper {

	int insert(Test record);
	
	List<Test> selectAll();
}
