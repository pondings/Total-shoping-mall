package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.ProductType;

@Repository
@Transactional(readOnly = true)
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{

	@Query("SELECT prodType FROM ProductType WHERE 1=1")
	List<ProductType> search(ProductType productType) ;
	
}
