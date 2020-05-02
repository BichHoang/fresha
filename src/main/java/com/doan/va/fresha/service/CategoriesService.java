package com.doan.va.fresha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.Categories;
import com.doan.va.fresha.repository.CategoriesRepository;

@Service
public class CategoriesService {
	@Autowired
	private CategoriesRepository categoriesRepository;
	
	public Iterable<Categories> findAll(){
		return categoriesRepository.findAll();
	}
	
	public Categories getOne(int id) {
		return categoriesRepository.getOne(id);
	}
	
	public Categories save(Categories cat) {
		return categoriesRepository.save(cat);
	}
	
	public void delete(Categories cat) {
		categoriesRepository.delete(cat);
	}
}
