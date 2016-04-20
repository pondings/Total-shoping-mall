package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.dto.SeDate;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;
import com.tsm.project.service.SubOrderService;

@RestController
@RequestMapping("subOrder")
public class SubOrderRescontroller {

	@Autowired
	SubOrderService subOrderService;

	@RequestMapping(value = "/searchSubOrderByOrder", method = RequestMethod.POST)
	ResponseEntity<?> searchSubOrderByOrder(@RequestBody Order order) {
		return new ResponseEntity<List<SubOrder>>(subOrderService.searchSubOrderByOrder(order), HttpStatus.OK);
	}

	
}
