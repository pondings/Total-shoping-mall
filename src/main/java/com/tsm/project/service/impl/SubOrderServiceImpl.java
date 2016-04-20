package com.tsm.project.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.dto.SeDate;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;
import com.tsm.project.repository.SubOrderRepository;
import com.tsm.project.service.SubOrderService;

@Service
@Transactional
public class SubOrderServiceImpl implements SubOrderService {

	@Autowired
	SubOrderRepository subOrderRepository;

	@Override
	public List<SubOrder> searchSubOrderByOrder(Order order) {
		// TODO Auto-generated method stub
		return subOrderRepository.searchByOrder(order);
	}

	
}
