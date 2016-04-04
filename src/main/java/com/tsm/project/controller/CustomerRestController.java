package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.model.Customer;
import com.tsm.project.service.CustomerService;

@RestController
@RequestMapping("cus")
public class CustomerRestController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value ="search", method = RequestMethod.POST)
	ResponseEntity<?> search(@RequestBody Customer customer){
		return new ResponseEntity<List<Customer>>(customerService.search(customer),HttpStatus.OK);
		
	}
	
	@RequestMapping(value="search",method = RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.create(customer),HttpStatus.OK);
	}
	
	
}
