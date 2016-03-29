package com.tsm.project.service;

import java.util.List;

import com.tsm.project.model.ProductType;

public interface ProductTypeService {
	
	List<ProductType> search(ProductType productType) ;
	
	ProductType create(ProductType productType) ;
	
	ProductType update(ProductType productType) ;
	
	void delete(int id) ;
}
