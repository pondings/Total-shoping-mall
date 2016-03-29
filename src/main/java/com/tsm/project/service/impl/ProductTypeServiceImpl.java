package com.tsm.project.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.ProductType;
import com.tsm.project.repository.ProductTypeRepository;
import com.tsm.project.service.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Autowired
	ProductTypeRepository productTypeRepository ;
	
	private static String getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication() ;
		return auth.getName();
	}

	@Override
	public List<ProductType> search(ProductType productType) {
		// TODO Auto-generated method stub
		return productTypeRepository.search(productType);
	}

	@Override
	public ProductType create(ProductType productType) {
		// TODO Auto-generated method stub		
		productType.setCreateBy(getUser());
		productType.setCreateDate(new Date());
		return productTypeRepository.save(productType);
	}

	@Override
	public ProductType update(ProductType productType) {
		// TODO Auto-generated method stub
		productType.setUpdateBy(getUser());
		productType.setUpdateDate(new Date());
		return productTypeRepository.save(productType);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productTypeRepository.delete(id);
	}
	
	
	
}
