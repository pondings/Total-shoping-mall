package com.tsm.project.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.config.PersistenceConfig;
import com.tsm.project.model.Order;
import com.tsm.project.model.SubOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { PersistenceConfig.class })
@Transactional

public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository ;
	
	@Autowired
	SubOrderRepository subOrderRepository ;
	
	@Rollback(false)
	@Test
	public void test(){
		Order order = new Order() ;
		
		order.setOrderCode("ORDER001");
		order.setStatus(true);

		orderRepository.search(order);
	}
	
}
