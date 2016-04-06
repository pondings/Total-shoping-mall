package com.tsm.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.EmpInfo;
import com.tsm.project.model.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends CrudRepository<User, String> {

	@Query("SELECT user FROM User user LEFT JOIN FETCH user.empInfo WHERE 1=1 AND (user.username = :#{#param})")
	User findEmpByUsername(@Param("param") String user);

}
