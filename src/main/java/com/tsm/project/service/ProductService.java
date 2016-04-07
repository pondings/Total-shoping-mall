package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.Product;

public interface ProductService {

	List<Product> search(Product product) ;
	
	List<Product> searchModal(Product product) ;
	
	Product create(Product product) ;
	
	Product update(Product product) ;
	
	void delete(int id) ;
	
	Product searchProd(Product product) ;
	
}
