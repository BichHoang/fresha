package com.doan.va.fresha.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categories {
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_cat")
	private int idCat;
	private String name;
	private boolean enable;
	public Categories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categories(int idCat, String name, boolean enable) {
		super();
		this.idCat = idCat;
		this.name = name;
		this.enable = enable;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
}
