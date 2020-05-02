package com.doan.va.fresha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Integer>{
	//todo
}