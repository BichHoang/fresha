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
@Table(name = "orders")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Orders {
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_order")
	private int id_order;
	private String customer;
	private String email;
	private String phone;
	private String address;
	private String note;
	private int id_user;
	private int status;
	private Date created;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Orders(int id_order, String customer, String email, String phone, String address, String note, int id_user,
			int status, Date created) {
		super();
		this.id_order = id_order;
		this.customer = customer;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.note = note;
		this.id_user = id_user;
		this.status = status;
		this.created = created;
	}

	public int getId_order() {
		return id_order;
	}

	public void setId_order(int id_order) {
		this.id_order = id_order;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
