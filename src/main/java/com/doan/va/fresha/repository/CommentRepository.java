package com.doan.va.fresha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doan.va.fresha.entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	//todo
}