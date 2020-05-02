package com.doan.va.fresha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value = "SELECT COUNT(*) FROM product WHERE id_cat =  ?1", nativeQuery = true)
	int countProductOfCategory(int idCat);
}