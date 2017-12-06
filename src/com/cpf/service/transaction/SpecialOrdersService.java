package com.cpf.service.transaction;

import java.util.List;

import com.cpf.beans.transaction.OrderBean;

public interface SpecialOrdersService {
	public List<OrderBean> findlatestOrderokList();
}
