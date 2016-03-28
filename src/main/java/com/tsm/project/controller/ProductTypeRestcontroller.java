package com.tsm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.service.ProductTypeService;

@RestController
@RequestMapping("/prodType")
public class ProductTypeRestcontroller {

	@Autowired
	ProductTypeService productTypeService ;
	
}
