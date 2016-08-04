package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="create",method = RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.create(customer),HttpStatus.OK);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT)
	ResponseEntity<?> update(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.update(customer), HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable int id) {
		try {
			customerService.delete(id);
			return new ResponseEntity<Customer>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Please contact a maintenance can't Delete", HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
}
