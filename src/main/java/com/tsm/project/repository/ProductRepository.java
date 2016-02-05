package com.tsm.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Product;

@Transactional(readOnly = true)
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{

}
