package com.tsm.project.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.dto.orderDto;
import com.tsm.project.model.EmpInfo;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;
import com.tsm.project.model.User;
import com.tsm.project.repository.EmployeeRepository;
import com.tsm.project.repository.OrderRepository;
import com.tsm.project.repository.SubOrderRepository;
import com.tsm.project.repository.UserRepository;
import com.tsm.project.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	SubOrderRepository subOrderRepository;

	private static String getUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}

	@Override
	public List<Order> search(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.search(order);
	}

	@Override
	public Order create(Order order) {
		// TODO Auto-generated method stub

		User user = userRepository.findEmpByUsername(getUser());

		Order insertOrder = new Order();
		insertOrder.setEmpInfo(user.getEmpInfo());
		insertOrder.setCustomer(order.getCustomer());
		insertOrder.setOrderDate(new Date());
		insertOrder.setOrderNet(order.getOrderNet());
		insertOrder.setOrderRemark(order.getOrderRemark());
		insertOrder.setStatus(order.getStatus());

		Order getOrder = orderRepository.save(insertOrder);

		for (SubOrder subOrder : order.getListOfSubOrder()) {
			SubOrder insertSubOrder = new SubOrder();
			insertSubOrder.setOrder(getOrder);
			insertSubOrder.setProduct(subOrder.getProduct());
			insertSubOrder.setSubQuantity(subOrder.getSubQuantity());
			insertSubOrder.setSubTotal(subOrder.getSubTotal());

			subOrderRepository.save(insertSubOrder);
		}

		getOrder.setOrderCode("order" + getOrder.getId());

		return orderRepository.save(getOrder);
	}

	@Override
	public List<Order> orderSearch(orderDto order) {
		Calendar calStartDate = Calendar.getInstance();
		Calendar calEndDate = Calendar.getInstance();
		calStartDate.set(0001, 01, 01);
		calEndDate.set(9999, 12, 31);

		if (order.getStartDate() == null && order.getEndDate() == null) {
			order.setStartDate(calStartDate.getTime());
			order.setEndDate(calEndDate.getTime());
			return orderRepository.searchOrder(order);
		} else if (order.getStartDate() != null && order.getEndDate() == null) {
			order.setEndDate(calEndDate.getTime());
			return orderRepository.searchOrder(order);
		} else if (order.getStartDate() == null && order.getEndDate() != null) {
			order.setStartDate(calStartDate.getTime());
			return orderRepository.searchOrder(order);
		} else {
			return orderRepository.searchOrder(order);
		}

	}


}
