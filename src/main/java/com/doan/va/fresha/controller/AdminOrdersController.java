package com.doan.va.fresha.controller;

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

import com.doan.va.fresha.entities.Orders;
import com.doan.va.fresha.service.OrdersService;

@RestController
@RequestMapping("/api/admin")
public class AdminOrdersController {
	@Autowired
	private OrdersService objService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> listAllOrders() {
		List<Orders> list = (List<Orders>) objService.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public Orders findOrder(@PathVariable("id") int id) {
		Orders order = objService.getOne(id);
		if (order == null) {
			ResponseEntity.notFound().build();
		}
		return order;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String creatingJsonString() throws JSONException {
		  JSONArray pets = new JSONArray();
		  pets.put("cat");
		  pets.put("dog");
		  JSONObject person = new JSONObject();
		  person.put("name", "John Brown");
		  person.put("age", 35);
		  person.put("pets", pets);
		  return person.toString(2);
		}
}
