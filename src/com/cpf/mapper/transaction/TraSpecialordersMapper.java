package com.cpf.mapper.transaction;

import java.util.List;

import com.cpf.beans.transaction.OrderBean;
import com.cpf.beans.transaction.TraSpecialorders;

public interface TraSpecialordersMapper {
    
	List<OrderBean> findlatestOrderokList();
}