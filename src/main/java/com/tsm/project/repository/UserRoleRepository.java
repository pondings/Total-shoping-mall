package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.User;
import com.tsm.project.model.UserRole;

@Repository
@Transactional(readOnly=true)
public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {

	@Query("SELECT role FROM UserRole role LEFT JOIN FETCH role.user WHERE 1=1 AND (role.user.username like %:#{#param.user.username != null ? #param.user.username :''}%) "
			+ "AND (role.role like %:#{#param.role != null ? #param.role:''}%) "
			+ "AND (role.user.enabled = :#{#param.user.enabled})")
	List<User> search(@Param("param")UserRole userRole) ;
	
	@Query("SELECT NEW com.tsm.project.dto.userDto(role.id,role.role) FROM UserRole role")
	List<UserRole> getRole() ;
	
}
