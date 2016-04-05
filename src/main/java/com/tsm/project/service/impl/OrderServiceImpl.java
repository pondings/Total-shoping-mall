package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Order;
import com.tsm.project.repository.OrderRepository;
import com.tsm.project.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository ;
	
	@Override
	public List<Order> search(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.search(order);
	}

}
