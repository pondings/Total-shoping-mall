package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Customer;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	@Query("SELECT cus FROM Customer cus WHERE 1=1 AND ( cus.custCode like %:#{#param.custCode != null? #param.custCode:''}%) AND (cus.custName like %:#{#param.custName != null? #param.custName:''}%)"
			+ " AND (cus.custName IS NOT NULL)")
	List<Customer> search(@Param("param") Customer customer);

}
