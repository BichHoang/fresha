package com.doan.va.fresha.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "detail_order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DetailOrder {
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_detail")
	private int idDeatail;
	private int id_product;
	private int id_order;
	private float price;
	private int quantity;
	
	public DetailOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailOrder(int idDeatail, int id_product, int id_order, float price, int quantity) {
		super();
		this.idDeatail = idDeatail;
		this.id_product = id_product;
		this.id_order = id_order;
		this.price = price;
		this.quantity = quantity;
	}

	public int getIdDeatail() {
		return idDeatail;
	}

	public void setIdDeatail(int idDeatail) {
		this.idDeatail = idDeatail;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
