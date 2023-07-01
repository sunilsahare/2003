package com.springsecurity3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
public class AdminController {

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("'admin/test' api can be accessible by anyone.");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Secured 'GET' API accessible only by the ADMIN amd USER.");
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> post() {
		return ResponseEntity.ok("Secured 'POST' API accessible only by the ADMIN.");
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> put() {
		return ResponseEntity.ok("Secured 'PUT' API accessible only by the ADMIN.");
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> delete() {
		return ResponseEntity.ok("Secured 'DELETE' API accessible only by the ADMIN.");
	}

}
