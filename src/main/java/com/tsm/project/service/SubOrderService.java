package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;

public interface SubOrderService {

	List<SubOrder> searchSubOrderByOrder(Order order) ;
	
}
