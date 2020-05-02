package com.doan.va.fresha.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.service.CategoriesService;
import com.doan.va.fresha.utils.EnableEntities;
import com.doan.va.fresha.entities.Categories;

@RestController
@RequestMapping("/api")
public class CategoriesController {
	@Autowired
	private CategoriesService categoriesService;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Categories>> listAllCategoriesEnable(){
		List<Categories> listCategories= (List<Categories>) categoriesService.findAll();
		listCategories = EnableEntities.enableCategorie(listCategories);
		if(listCategories.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Categories>>(listCategories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Categories>> listAllCategories(){
		List<Categories> listCategories= (List<Categories>) categoriesService.findAll();
		if(listCategories.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Categories>>(listCategories, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public Categories findCategories(@PathVariable("id") int id) {
		Categories categories= categoriesService.getOne(id);
		if(categories == null) {
			System.out.println("Loi");
			ResponseEntity.notFound().build();
		}
		return categories;
	}
	
	@RequestMapping(value = "/admin/category/", method = RequestMethod.POST)
	public Categories saveCategory(@Valid @RequestBody Categories category) {
		return categoriesService.save(category);
	}
	
	@RequestMapping(value = "/admin/category/", method = RequestMethod.PUT)
	public ResponseEntity<Categories> updateCategory(@Valid @RequestBody Categories cat) {
		Categories category = categoriesService.getOne(cat.getIdCat());
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	    category.setName(cat.getName());
	    category.setEnable(cat.isEnable());

	    Categories updatedCategory = categoriesService.save(category);
	    return ResponseEntity.ok(updatedCategory);
	}
	
	@RequestMapping(value = "/admin/cat_status/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Categories> enableCategory(@PathVariable(value = "id") int id) {
		Categories category = categoriesService.getOne(id);
	    if(category == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    category.setEnable(!category.isEnable());

	    Categories updatedCategory = categoriesService.save(category);
	    return ResponseEntity.ok(updatedCategory);
	}
	
	@RequestMapping(value = "/admin/category/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Categories> deleteCategory(@PathVariable(value = "id") int id) {
		Categories category = categoriesService.getOne(id);
	    if(category == null) {
	    	System.out.println("Khong ton tai");
	        return ResponseEntity.notFound().build();
	    }
	    categoriesService.delete(category);
	    return ResponseEntity.ok().build();
	}
}
