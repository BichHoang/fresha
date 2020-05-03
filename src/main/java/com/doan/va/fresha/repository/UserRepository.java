package com.doan.va.fresha.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//todo
	
	@Query(value = "SELECT * FROM `user` WHERE email= ?1 AND password= ?2", nativeQuery = true)
	User checkUser(String email, String password);
	
	Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);
}