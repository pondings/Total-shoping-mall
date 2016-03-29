package com.tsm.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tsm.project.model.ProductType;

@Repository
@Transactional(readOnly = true)
public interface ProductTypeRepository extends CrudRepository<ProductType, Integer>{

	@Query("SELECT prodType FROM ProductType prodType WHERE 1=1 AND (prodType.typeCode like %:#{#param.typeCode != null ? param.typeCode:''}%) "
			+ "AND (prodType.typeName like %:#{#param.typeName != null ? param.typeName:''}%)")
	List<ProductType> search(@Param("param")ProductType productType) ;
	
}
