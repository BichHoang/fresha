package com.doan.va.fresha.utils;

import java.util.ArrayList;
import java.util.List;

import com.doan.va.fresha.entities.Categories;

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
}
