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

import com.doan.va.fresha.entities.User;
import com.doan.va.fresha.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService objService;
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUserEnable(){
		List<User> listUser= (List<User>) objService.findAll();
		if(listUser.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findUser(@PathVariable("id") int id) {
		User User= objService.getOne(id);
		if(User == null) {
			ResponseEntity.notFound().build();
		}
		return User;
	}
	
	@RequestMapping(value = "/user/", method = RequestMethod.POST)
	public User saveUser(@Valid @RequestBody User param) {
		return objService.save(param);
	}
	
	@RequestMapping(value = "/admin/user_enable/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> enableCategory(@PathVariable(value = "id") int id) {
		User obj = objService.getOne(id);
	    if(obj == null) {
	        return ResponseEntity.notFound().build();
	    }
	    
	    obj.setEnable(!obj.isEnable());

	    User newObj = objService.save(obj);
	    return ResponseEntity.ok(newObj);
	}
	
	@RequestMapping(value = "/admin/user/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteCategory(@PathVariable(value = "id") int id) {
		User obj = objService.getOne(id);
	    if(obj == null) {
	    	System.out.println("Khong ton tai");
	        return ResponseEntity.notFound().build();
	    }
	    objService.delete(obj);
	    return ResponseEntity.ok().build();
	}
}
