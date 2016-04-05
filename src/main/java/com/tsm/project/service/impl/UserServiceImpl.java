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
public class UserServiceImpl implements UserService {

	@Autowired
	UserRoleRepository userRoleRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> search(UserRole userRole) {
		// TODO Auto-generated method stub
		return userRoleRepository.search(userRole);
	}

	@Override
	public List<UserRole> getRole() {
		// TODO Auto-generated method stub
		return userRoleRepository.getRole();
	}

	@Override
	public UserRole create(UserRole userRole) {

		User insertUser = new User();
		insertUser.setEmpInfo(userRole.getUser().getEmpInfo());
		insertUser.setUsername(userRole.getUser().getUsername());
		insertUser.setPassword(userRole.getUser().getPassword());
		insertUser.setEnabled(true);

		UserRole insertRole = new UserRole();

		insertRole.setRole(userRole.getRole());
		insertRole.setUser(userRepository.save(insertUser));

		return userRoleRepository.save(insertRole);
	}

	@Override
	public UserRole update(UserRole userRole) {
		User inserUser = new User();

		inserUser.setId(userRole.getUser().getId());
		inserUser.setUsername(userRole.getUser().getUsername());
		inserUser.setPassword(userRole.getUser().getPassword());
		inserUser.setEmpInfo(userRole.getUser().getEmpInfo());
		inserUser.setEnabled(userRole.getUser().getEnabled());

		userRoleRepository.delete(userRole.getId());

		UserRole insertUserRole = new UserRole();

		insertUserRole.setRole(userRole.getRole());
		insertUserRole.setUser(userRepository.save(inserUser));

		return userRoleRepository.save(insertUserRole);
	}

	@Override
	public User setStatus(User user) {
		// TODO Auto-generated method stub
		User insertUser = new User();

		insertUser.setEmpInfo(user.getEmpInfo());
		insertUser.setId(user.getId());
		insertUser.setPassword(user.getPassword());
		insertUser.setUsername(user.getUsername());

		if (user.getEnabled() == true) {
			insertUser.setEnabled(false);
			return userRepository.save(insertUser);
		} else {
			insertUser.setEnabled(true);
			return userRepository.save(insertUser);
		}
	}

}
