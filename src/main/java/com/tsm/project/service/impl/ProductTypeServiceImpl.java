package com.tsm.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.repository.ProductTypeRepository;
import com.tsm.project.service.ProductTypeService;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService{

	@Autowired
	ProductTypeRepository productTypeRepository ;
	
}
