package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.User;
import com.tsm.project.model.UserRole;

public interface UserService {

	
	List<User> search(UserRole userRole);
	
	List<UserRole> getRole() ;
	
	UserRole create(UserRole userRole) ;
	
	
	UserRole update(UserRole userRole) ;
	
	User setStatus(User user) ;
}
