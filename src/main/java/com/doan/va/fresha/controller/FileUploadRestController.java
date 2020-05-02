package com.doan.va.fresha.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.doan.va.fresha.entities.Product;
import com.doan.va.fresha.service.ProductService;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class FileUploadRestController {
	@Autowired
	private ProductService objService;
	private static final Logger logger = Logger.getLogger(FileUploadRestController.class.getName());
	@PostMapping("/upload")
	public ResponseEntity<Product> uploadData(@RequestParam("file") MultipartFile file, @RequestParam("test") String test) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		logger.info("inputStream: " + inputStream);
		logger.info("originalName: " + originalName);
		logger.info("name: " + name);
		logger.info("contentType: " + contentType);
		logger.info("size: " + size);
		// Do processing with uploaded file data in Service layer
		
		JsonParser springParser = JsonParserFactory.getJsonParser();
		Map<String, Object> map = springParser.parseMap(test);
		
		System.out.println(test);
		Product obj = objService.getOne(4);
		obj.setPic(file.getBytes());
		Product newObj = objService.save(obj);;
		return ResponseEntity.ok(newObj);
	}
}
