package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.Product;

@Transactional(readOnly = true)
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query("SELECT prod FROM Product prod LEFT JOIN FETCH prod.productType WHERE 1=1 AND (prod.prodCode like %:#{#param.prodCode != null ? #param.prodCode : ''}%) "
			+ "AND (prod.prodName like %:#{#param.prodName != null ? #param.prodName :''}%) "
			+ "AND (prod.prodBrand like %:#{#param.prodBrand != null ? #param.prodBrand :''}%) "
			+ "AND (prod.prodModel like %:#{#param.prodModel != null ? #param.prodModel :''}%) "
			+ "AND (prod.productType.typeName like %:#{#param.productType.typeName != null ? #param.productType.typeName :''}%)")
	List<Product> search(@Param("param") Product product);

	@Query("SELECT prod FROM Product prod WHERE prod.prodCode = :#{#param.prodCode}")
	Product searchCode(@Param("param") Product product);
	
	@Query("SELECT prod FROM Product prod WHERE 1=1 AND (prod.prodCode like %:#{#param.prodCode != null ? #param.prodCode : ''}%)")
List<Product> searchmodal(@Param("param") Product product);
}
