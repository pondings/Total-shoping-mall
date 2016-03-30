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

import com.tsm.project.model.Product;
import com.tsm.project.service.ProductService;

@RestController
@RequestMapping("prod")
public class ProductRestController {

	@Autowired
	ProductService productService ;
	
	@RequestMapping(value="search",method=RequestMethod.POST)
	ResponseEntity<?> search(@RequestBody Product product){
		return new ResponseEntity<List<Product>>(productService.search(product),HttpStatus.OK) ;
	}
	
	@RequestMapping(value="create" , method=RequestMethod.POST)
	ResponseEntity<?> create(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.create(product),HttpStatus.OK) ;
	}
	
	@RequestMapping(value="update" , method= RequestMethod.PUT)
	ResponseEntity<?> update(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.update(product),HttpStatus.OK);
	}
	
	@RequestMapping(value="delete/{id}" , method = RequestMethod.DELETE)
	void delete(@PathVariable int id){
		productService.delete(id);
	}
}
