package com.doan.va.fresha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.Orders;
import com.doan.va.fresha.repository.OrdersRepository;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository objRes;
	
	public Iterable<Orders> findAll(){
		return objRes.findAll();
	}
	
	public Orders getOne(int id) {
		return objRes.getOne(id);
	}
	
	public Orders save(Orders obj) {
		return objRes.save(obj);
	}
	
	public void delete(Orders obj) {
		objRes.delete(obj);
	}
}
