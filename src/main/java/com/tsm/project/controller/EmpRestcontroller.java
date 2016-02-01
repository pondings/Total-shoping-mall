package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	@RequestMapping(value = "create", method = RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody EmpInfo empInfo) {
		List<EmpInfo> dup = empService.duplicate(empInfo);
		if (!dup.isEmpty()) {
			return new ResponseEntity<>("Duplicate Employee", HttpStatus.NOT_IMPLEMENTED);
		}
		return new ResponseEntity<EmpInfo>(empService.create(empInfo), HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	ResponseEntity<?> update(@RequestBody EmpInfo empInfo) {
		return new ResponseEntity<EmpInfo>(empService.update(empInfo), HttpStatus.OK);
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	ResponseEntity<?> delete(@PathVariable int id) {
		try {
			empService.delete(id);
			return new ResponseEntity<EmpInfo>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Please contact a maintenance", HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@RequestMapping(value = "search", method = RequestMethod.POST)
	ResponseEntity<?> search(@RequestBody EmpInfo empInfo) {
		return new ResponseEntity<List<EmpInfo>>(empService.search(empInfo), HttpStatus.OK);
	}
}
