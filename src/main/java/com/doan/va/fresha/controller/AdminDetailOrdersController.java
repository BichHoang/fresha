package com.doan.va.fresha.controller;

import java.util.Base64;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.entities.Categories;
import com.doan.va.fresha.entities.DetailOrder;
import com.doan.va.fresha.entities.Orders;
import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.service.CategoriesService;
import com.doan.va.fresha.service.DetailOrderService;
import com.doan.va.fresha.service.OrdersService;
import com.doan.va.fresha.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminDetailOrdersController {
	@Autowired
	private DetailOrderService detailOrderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(value = "/detail_order/{id}", method = RequestMethod.GET)
	public String creatingJsonString(@PathVariable("id") int id) throws JSONException {
		List<DetailOrder> list = (List<DetailOrder>) detailOrderService.listDetailByOrderID(id);
		JSONArray result = new JSONArray();
		
		for (DetailOrder item : list) {
			JSONObject detaiOrder = new JSONObject();
			detaiOrder.put("id_detail", item.getIdDeatail());
			detaiOrder.put("id_product", item.getId_product());
			detaiOrder.put("price", item.getPrice());
			detaiOrder.put("quantity", item.getQuantity());
			
			Product product = productService.getOne(item.getId_product());
			JSONObject sanpham = new JSONObject();
			sanpham.put("name", product.getName());
			String s = Base64.getEncoder().encodeToString(product.getPic());
			sanpham.put("pic", s);
			Categories category= categoriesService.getOne(product.getId_cat());
			sanpham.put("category", category.getName());
			detaiOrder.put("product", sanpham);
			
			result.put(detaiOrder);
		}
		
		return result.toString(2);
	}
}
