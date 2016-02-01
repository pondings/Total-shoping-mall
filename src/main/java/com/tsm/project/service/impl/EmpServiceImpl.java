package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.EmpInfo;
import com.tsm.project.repository.EmployeeRepository;
import com.tsm.project.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmpInfo create(EmpInfo empInfo) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empInfo);
	}

	@Override
	public EmpInfo update(EmpInfo empInfo) {
		// TODO Auto-generated method stub
		return employeeRepository.save(empInfo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		employeeRepository.delete(id);
	}

	@Override
	public Iterable<EmpInfo> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
}
