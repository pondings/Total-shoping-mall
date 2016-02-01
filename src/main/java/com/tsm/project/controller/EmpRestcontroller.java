package com.tsm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.model.EmpInfo;
import com.tsm.project.service.EmpService;

@RestController
@RequestMapping("emp")
public class EmpRestcontroller {

	@Autowired
	EmpService empService;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	EmpInfo create(@RequestBody EmpInfo empInfo) {
		return empService.create(empInfo);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	EmpInfo update(@RequestBody EmpInfo empInfo) {
		return empService.update(empInfo);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	void delete(@PathVariable int id) {
		empService.delete(id);
	}
	
	@RequestMapping(value="findAll" , method = RequestMethod.GET)
	Iterable<EmpInfo> findAll(){
		return empService.findAll() ;
	}
}
