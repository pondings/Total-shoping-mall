package com.tsm.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Product;
import com.tsm.project.repository.ProductRepository;
import com.tsm.project.service.ProductService;

@Transactional
@Service
public class ProductServiceImpl  implements ProductService{

	@Autowired
	ProductRepository prodRepo ;
	
	private static String getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
		return auth.getName();
	}
	
	@Override
	public List<Product> search(Product product) {
		return prodRepo.search(product);
	}

	@Override
	public Product create(Product product) {
		product.setCreateBy(getUser());
		product.setCreateDate(new Date());
		return prodRepo.save(product);
	}

	@Override
	public Product update(Product product) {
		product.setUpdateBy(getUser());
		product.setUpdateDate(new Date());
		return prodRepo.save(product);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		prodRepo.delete(id);
	}

}
