package com.doan.va.fresha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductService objService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProductEnable() {
		List<Product> listProduct = (List<Product>) objService.findAll();
		if (listProduct.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product findProduct(@PathVariable("id") int id) {
		System.out.println("vao roi");
		Product Product = objService.getOne(id);
		if (Product == null) {
			System.out.println("Loi");
			ResponseEntity.notFound().build();
		}
		return Product;
	}
}
