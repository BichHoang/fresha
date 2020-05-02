package com.doan.va.fresha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository objRes;
	
	public Iterable<Product> findAll(){
		return objRes.findAll();
	}
	
	public Product getOne(int id) {
		return objRes.getOne(id);
	}
	
	public Product save(Product obj) {
		return objRes.save(obj);
	}
	
	public void delete(Product obj) {
		objRes.delete(obj);
	}
	
	public int countProductOfCategory(int idCat) {
		return objRes.countProductOfCategory(idCat);
	}
}
