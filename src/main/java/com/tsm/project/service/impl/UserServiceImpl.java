package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.User;
import com.tsm.project.model.UserRole;
import com.tsm.project.repository.UserRepository;
import com.tsm.project.repository.UserRoleRepository;
import com.tsm.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserRoleRepository userRepo ;
	
	@Autowired
	UserRepository userRepository ;
	
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

	@Override
	public UserRole create(UserRole userRole) {
		
		User insertUser = new User() ;
		insertUser.setEmpInfo(userRole.getUser().getEmpInfo()); 
		insertUser.setUsername(userRole.getUser().getUsername());
		insertUser.setPassword(userRole.getUser().getPassword());
		insertUser.setEnabled(true);
		
		userRepository.save(insertUser) ;
		
		UserRole userRoleInsert = new UserRole() ;
		
		userRoleInsert.setRole(userRole.getRole());
		userRoleInsert.setUser(userRole.getUser());
		
		userRepo.save(userRoleInsert) ;
		
		return userRole ;
	}

}
