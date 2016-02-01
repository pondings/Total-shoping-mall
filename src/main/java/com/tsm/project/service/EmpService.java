package com.tsm.project.service;

import com.tsm.project.model.EmpInfo;

public interface EmpService {

	Iterable<EmpInfo> findAll() ;
	EmpInfo create(EmpInfo empInfo);
	EmpInfo update(EmpInfo empInfo);
	void delete(int id);
	
}
