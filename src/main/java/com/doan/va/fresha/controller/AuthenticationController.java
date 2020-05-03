package com.doan.va.fresha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doan.va.fresha.entities.User;
import com.doan.va.fresha.service.UserService;
import com.doan.va.fresha.utils.TokenJWTUtils;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

	@Autowired
	private UserService objService;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login() {
		String email = "user1@gmail.com";
		String password = "e10adc3949ba59abbe56e057f20f883e";
		User user= objService.checkUser(email, password);
        //Kiểm tra user/pass trong CSDL
        //Nếu hợp lệ thì sinh JWT theo userId hoặc username và trả về cho client
        if(user != null){
           String token = TokenJWTUtils.generateJwt(email);
           return token;
        }
        //User/pass không hợp lệ thì đăng nhập không thành công
        return null;
   }
}
