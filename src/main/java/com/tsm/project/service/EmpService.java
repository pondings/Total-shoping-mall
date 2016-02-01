package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.EmpInfo;

public interface EmpService {

	EmpInfo create(EmpInfo empInfo);

	EmpInfo update(EmpInfo empInfo);

	void delete(int id);

	List<EmpInfo> search(EmpInfo empInfo);

	EmpInfo findOne(int id);
	
	List<EmpInfo> duplicate(EmpInfo empInfo) ;

}
