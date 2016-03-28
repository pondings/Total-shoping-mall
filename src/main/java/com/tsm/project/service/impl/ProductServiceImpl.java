package com.tsm.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public List<Product> search(Product product) {
		return prodRepo.search(product);
	}

}
