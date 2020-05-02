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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminProductController {
	@Autowired
	private ProductService objService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> listProduct = (List<Product>) objService.findAll();
		if (listProduct.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(listProduct, HttpStatus.OK);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Product findProduct(@PathVariable("id") int id) {
		Product Product = objService.getOne(id);
		if (Product == null) {
			ResponseEntity.notFound().build();
		}
		return Product;
	}

	@RequestMapping(value = "/product/", method = RequestMethod.POST)
	public Product saveProduct(@Valid @RequestBody Product param) {
		System.out.println(param.toString());
		return objService.save(param);
	}

	@RequestMapping(value = "/product/", method = RequestMethod.PUT)
	public ResponseEntity<Product> updateProduct(@Valid @RequestBody Product param) {
		Product obj = objService.getOne(param.getId_product());
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		
		obj.setName(param.getName());
		obj.setPreview(param.getPreview());
		obj.setDetail(param.getDetail());
		obj.setPic(param.getPic());
		obj.setPrice(param.getPrice());
		obj.setRating(param.getRating());
		obj.setId_cat(param.getId_cat());
		obj.setQuantity(param.getQuantity());
		obj.setEnable(param.isEnable());
		
		Product newObj = objService.save(obj);
		return ResponseEntity.ok(newObj);
	}

	@RequestMapping(value = "/product_enable/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Product> enableCategory(@PathVariable(value = "id") int id) {
		Product obj = objService.getOne(id);
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}

		obj.setEnable(!obj.isEnable());

		Product newObj = objService.save(obj);
		return ResponseEntity.ok(newObj);
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> deleteCategory(@PathVariable(value = "id") int id) {
		Product obj = objService.getOne(id);
		if (obj == null) {
			System.out.println("Khong ton tai");
			return ResponseEntity.notFound().build();
		}
		objService.delete(obj);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/product_of_category/{id}", method = RequestMethod.GET)
	public int countQuantityProduct(@PathVariable(value = "id") int id) {
		int rs = objService.countProductOfCategory(id);
		return rs;
	}
}
