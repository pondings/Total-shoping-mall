package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.User;
import com.tsm.project.model.UserRole;
import com.tsm.project.repository.UserRepository;
import com.tsm.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo ;
	
	@Override
	public List<User> search(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRepo.search(userRole);
	}

	@Override
	public List<UserRole> getRole() {
		// TODO Auto-generated method stub
		return userRepo.getRole();
	}

}
