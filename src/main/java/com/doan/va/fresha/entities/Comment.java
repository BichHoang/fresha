package com.doan.va.fresha.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment {
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_cmt")
	private int idCmt;
	private int id_user;
	private int id_product;
	private String content;
	private int rating;
	private boolean enable;
	private Date created;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int idCmt, int id_user, int id_product, String content, int rating, boolean enable, Date created) {
		super();
		this.idCmt = idCmt;
		this.id_user = id_user;
		this.id_product = id_product;
		this.content = content;
		this.rating = rating;
		this.enable = enable;
		this.created = created;
	}

	public int getIdCmt() {
		return idCmt;
	}

	public void setIdCmt(int idCmt) {
		this.idCmt = idCmt;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
