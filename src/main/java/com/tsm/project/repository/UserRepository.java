package com.tsm.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, String>{

	
	
}
