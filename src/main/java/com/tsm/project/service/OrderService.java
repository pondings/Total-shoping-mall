package com.tsm.project.service;

import java.util.List;

import com.tsm.project.dto.orderDto;
import com.tsm.project.model.Order;

public interface OrderService {

	List<Order> search(Order order) ;

	Order create(Order order) ;
	
	List<Order> orderSearch(orderDto order) ;
}
