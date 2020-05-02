package com.doan.va.fresha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
	//todo
}