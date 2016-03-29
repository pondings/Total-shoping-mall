package com.tsm.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tsm.project.model.ProductType;
import com.tsm.project.service.ProductTypeService;

@RestController
@RequestMapping("prodType")
public class ProductTypeRestcontroller {

	@Autowired
	ProductTypeService productTypeService;

	@RequestMapping(value = "search", method = RequestMethod.POST)
	ResponseEntity<?> search(@RequestBody ProductType productType) {
		return new ResponseEntity<List<ProductType>>(productTypeService.search(productType), HttpStatus.OK);
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody ProductType productType) {
		return new ResponseEntity<ProductType>(productTypeService.create(productType), HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	ResponseEntity<?> update(@RequestBody ProductType productType) {
		return new ResponseEntity<ProductType>(productTypeService.update(productType), HttpStatus.OK);
	}
	
	@RequestMapping(value="delete/{id}" , method = RequestMethod.DELETE)
	void delete(@PathVariable int id){
		productTypeService.delete(id);
	}

}
