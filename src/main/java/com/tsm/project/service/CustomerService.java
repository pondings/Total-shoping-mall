package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.Customer;

public interface CustomerService {
	
	List<Customer> search(Customer customer); 
	
	Customer create(Customer customer);
	
	Customer update(Customer customer);
	
	void delete(int id);
	
}
