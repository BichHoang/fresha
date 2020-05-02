package com.doan.va.fresha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.DetailOrder;
import com.doan.va.fresha.repository.DetailOrderRepository;

@Service
public class DetailOrderService {
	@Autowired
	private DetailOrderRepository objRes;
	
	public Iterable<DetailOrder> findAll(){
		return objRes.findAll();
	}
	
	public DetailOrder getOne(int id) {
		return objRes.getOne(id);
	}
	
	public DetailOrder save(DetailOrder obj) {
		return objRes.save(obj);
	}
	
	public void delete(DetailOrder obj) {
		objRes.delete(obj);
	}
	
	public List<DetailOrder> listDetailByOrderID(int id){
		return objRes.listDetailByOrderID(id);
	}
}
