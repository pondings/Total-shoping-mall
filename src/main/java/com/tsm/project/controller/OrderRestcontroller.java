package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.model.Order;
import com.tsm.project.service.OrderService;

@RestController
@RequestMapping("order")
public class OrderRestcontroller {

	@Autowired
	OrderService orderService ;
	
	@RequestMapping(value="search" , method = RequestMethod.GET)
	ResponseEntity<?> search(@RequestBody Order order){
		return new ResponseEntity<List<Order>>(orderService.search(order),HttpStatus.OK) ;
	}
	
}
