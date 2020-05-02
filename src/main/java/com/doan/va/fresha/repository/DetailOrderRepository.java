package com.doan.va.fresha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.DetailOrder;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrder, Integer>{
	@Query(value = "SELECT * FROM `detail_order` WHERE id_order =  ?1", nativeQuery = true)
	List<DetailOrder> listDetailByOrderID(int id);
}