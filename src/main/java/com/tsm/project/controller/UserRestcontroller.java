package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.model.User;
import com.tsm.project.model.UserRole;
import com.tsm.project.repository.UserRepository;
import com.tsm.project.service.UserService;
import com.tsm.project.service.impl.ProductServiceImpl;

@RestController
@RequestMapping("user")
public class UserRestcontroller {

	@Autowired
	UserService userService ; 
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(value="search" , method = RequestMethod.POST)
	ResponseEntity<?> search(@RequestBody UserRole userRole){
		return new ResponseEntity<List<User>>(userService.search(userRole),HttpStatus.OK);
	}
	
	@RequestMapping(value="getRole" , method=RequestMethod.GET)
	List<UserRole> getRole(){
		return userService.getRole();
	}
	
	@RequestMapping(value="findall" , method = RequestMethod.GET)
	Iterable<UserRole> find(){
		return repo.findAll();
	}
}
