package com.doan.va.fresha.utils;

import java.util.ArrayList;
import java.util.List;

import com.doan.va.fresha.entities.Categories;
import com.doan.va.fresha.entities.Orders;

public class EnableEntities {

	public static List<Categories> enableCategorie(List<Categories> list) {
		List<Categories> enableListCat = new ArrayList<>();
		for (Categories category : list) {
			if(category.isEnable()) {
				enableListCat.add(category);
			}
		}
		return enableListCat;
	}
	
	public static List<Orders> enableOrders(List<Orders> list, boolean boo) {
		List<Orders> enableList = new ArrayList<>();
		for (Orders obj : list) {
			if(obj.isEnable() == boo) {
				enableList.add(obj);
			}
		}
		return enableList;
	}
}
