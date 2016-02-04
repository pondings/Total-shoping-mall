package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.User;

@Transactional(readOnly = true)
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT user FROM User user WHERE 1=1 AND user.username = :#{#param}")
	User findUser(@Param("param") String username);

}
