package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.dto.SeDate;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;

@Repository
@Transactional(readOnly = true)
public interface SubOrderRepository extends CrudRepository<SubOrder, Integer> {

	@Query("SELECT sub FROM SubOrder sub LEFT JOIN FETCH sub.order LEFT JOIN FETCH sub.product WHERE 1=1 "
			+ "AND (sub.order.id = :#{#param.id})")
	List<SubOrder> searchByOrder(@Param("param") Order order);

}
