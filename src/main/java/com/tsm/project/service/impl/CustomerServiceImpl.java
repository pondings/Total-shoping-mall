package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Customer;
import com.tsm.project.repository.CustomerRepository;
import com.tsm.project.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public List<Customer> search(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.search(customer);
	}

	@Override
	public Customer create(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		customerRepository.delete(id);
	}

	
	
}
