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
		return employeeRepository.save(empInfo);
	}

	@Override
	public EmpInfo update(EmpInfo empInfo) {
		return employeeRepository.save(empInfo);
	}

	@Override
	public void delete(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public List<EmpInfo> search(EmpInfo empInfo) {
		return employeeRepository.search(empInfo);
	}

	@Override
	public EmpInfo findOne(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<EmpInfo> duplicate(EmpInfo empInfo) {
		return employeeRepository.duplicateEmp(empInfo);
	}
	
}
