package com.doan.va.fresha.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.entities.Orders;
import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.service.OrdersService;
import com.doan.va.fresha.utils.EnableEntities;

@RestController
@RequestMapping("/api/admin")
public class AdminOrdersController {
	@Autowired
	private OrdersService objService;
//	@PreAuthorize("hasRole(1)")
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> listAllOrders() {
		List<Orders> list = (List<Orders>) objService.findAll();
		List<Orders> listEnable = EnableEntities.enableOrders(list, true);
		if (listEnable.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(listEnable, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders_disable", method = RequestMethod.GET)
	public ResponseEntity<List<Orders>> listDisOrders() {
		List<Orders> list = (List<Orders>) objService.findAll();
		List<Orders> listEnable = EnableEntities.enableOrders(list, false);
		if (listEnable.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Orders>>(listEnable, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	public Orders findOrder(@PathVariable("id") int id) {
		Orders order = objService.getOne(id);
		if (order == null) {
			ResponseEntity.notFound().build();
		}
		return order;
	}
	
	@RequestMapping(value = "/order_status/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Orders> enableCategory(@PathVariable(value = "id") int id, @RequestParam("status") int status) {
		Orders obj = objService.getOne(id);
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}

		obj.setStatus(status);

		Orders newObj = objService.save(obj);
		return ResponseEntity.ok(newObj);
	}
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Orders> deleteCategory(@PathVariable(value = "id") int id) {
		Orders obj = objService.getOne(id);
		if (obj == null) {
			return ResponseEntity.notFound().build();
		}
		obj.setEnable(false);
//		objService.delete(obj);
		objService.save(obj);
		return ResponseEntity.ok().build();
	}
}
