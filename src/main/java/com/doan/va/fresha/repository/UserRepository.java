package com.doan.va.fresha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//todo
}