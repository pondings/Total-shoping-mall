package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Order;


@Repository
@Transactional(readOnly = true)
public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("SELECT ord FROM Order ord WHERE 1=1 AND (ord.orderCode like %:#{#param.orderCode != null ? #param.orderCode : ''}%) "
			+ "AND (ord.status = :#{#param.status})") 
	List<Order> search(@Param("param")Order order);

}