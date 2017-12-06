package com.cpf.mapper.transaction;

import java.util.List;

import com.cpf.beans.transaction.TraCategories;

public interface TraCategoriesMapper {
	List<TraCategories> findCategories();
	
}