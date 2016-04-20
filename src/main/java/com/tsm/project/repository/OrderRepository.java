package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.dto.SeDate;
import com.tsm.project.dto.orderDto;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;

@Repository
@Transactional(readOnly = true)
public interface OrderRepository extends CrudRepository<Order, Integer> {

	@Query("SELECT ord FROM Order ord WHERE 1=1 AND (ord.orderCode like %:#{#param.orderCode != null ? #param.orderCode : ''}%) "
			+ "AND (ord.status = :#{#param.status})")
	List<Order> search(@Param("param") Order order);

	@Query("SELECT ord FROM Order ord  LEFT JOIN FETCH ord.customer LEFT JOIN FETCH ord.empInfo WHERE 1=1 AND (ord.orderCode like %:#{#param.orderCode != null ? #param.orderCode:''}%) "
			+ "AND (ord.customer.custCode like %:#{#param.custCode != null ? #param.custCode: ''}%) "
			+ "AND (ord.empInfo.empCode like %:#{#param.empCode != null ? #param.empCode:''}%) "
			+ "AND ord.orderDate >= :#{#param.startDate} AND ord.orderDate <= :#{#param.endDate}")
	List<Order> searchOrder(@Param("param") orderDto order);
	
}

