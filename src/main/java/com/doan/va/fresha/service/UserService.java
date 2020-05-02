package com.doan.va.fresha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.User;
import com.doan.va.fresha.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository objRes;
	
	public Iterable<User> findAll(){
		return objRes.findAll();
	}
	
	public User getOne(int id) {
		return objRes.getOne(id);
	}
	
	public User save(User obj) {
		return objRes.save(obj);
	}
	
	public void delete(User obj) {
		objRes.delete(obj);
	}
}
