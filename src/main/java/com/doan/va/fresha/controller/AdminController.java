package com.doan.va.fresha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "layout";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "pages/dashboard";
	}
}
