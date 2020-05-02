package com.doan.va.fresha.entities;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {
	@GeneratedValue(strategy=GenerationType.AUTO) // automatically generated primary key.
	@Id  // Primary key.
	@Column(name="id_product")
	private int id_product;
	private String name;
	private String preview;
	private String detail;
	@Lob
	@Column(name="pic")
    private byte[] pic;
	private float price;
	private int rating;
	private int id_cat;
	private int quantity;
	private int discount;
	private boolean enable;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id_product, String name, String preview, String detail, byte[] pic, float price, int rating,
			int id_cat, int quantity, int discount, boolean enable) {
		super();
		this.id_product = id_product;
		this.name = name;
		this.preview = preview;
		this.detail = detail;
		this.pic = pic;
		this.price = price;
		this.rating = rating;
		this.id_cat = id_cat;
		this.quantity = quantity;
		this.discount = discount;
		this.enable = enable;
	}
	public int getId_product() {
		return id_product;
	}
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getId_cat() {
		return id_cat;
	}
	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", name=" + name + ", preview=" + preview + ", detail=" + detail
				+ ", pic=" + Arrays.toString(pic) + ", price=" + price + ", rating=" + rating + ", id_cat=" + id_cat
				+ ", quantity=" + quantity + ", discount=" + discount + ", enable=" + enable + "]";
	}
}
