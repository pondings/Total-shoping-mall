package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.EmpInfo;

@Repository
@Transactional(readOnly = true)
public interface EmployeeRepository extends CrudRepository<EmpInfo, Integer> {

	@Query("SELECT emp FROM EmpInfo emp WHERE 1=1 AND (emp.empCode like %:#{#param.empCode != null ? #param.empCode:''}%) AND (emp.empName like %:#{#param.empName != null ? #param.empName:''}%)")
	List<EmpInfo> search(@Param("param") EmpInfo empInfo);

	@Query("SELECT emp FROM EmpInfo emp WHERE 1=1 AND emp.empCode = :#{#param.empCode}")
	List<EmpInfo> duplicateEmp(@Param("param") EmpInfo empInfo);

}
