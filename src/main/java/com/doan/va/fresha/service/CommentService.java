package com.doan.va.fresha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.va.fresha.entities.Comment;
import com.doan.va.fresha.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository cmtRepository;
	
	public Iterable<Comment> findAll(){
		return cmtRepository.findAll();
	}
	
	public Comment getOne(int id) {
		return cmtRepository.getOne(id);
	}
	
	public Comment save(Comment cmt) {
		return cmtRepository.save(cmt);
	}
	
	public void delete(Comment cmt) {
		cmtRepository.delete(cmt);
	}
}
