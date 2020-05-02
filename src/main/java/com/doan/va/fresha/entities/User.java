package com.doan.va.fresha.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_user")
	private int id_user;
	private String fullname;
	private String email;
	private String phone;
	private String address;
	private String password;
	private boolean enable;
	private int role;
	private Date created;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id_user, String fullname, String email, String phone, String address, String password,
			boolean enable, int role, Date created) {
		super();
		this.id_user = id_user;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.password = password;
		this.enable = enable;
		this.role = role;
		this.created = created;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
}
