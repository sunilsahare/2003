package com.springsecurity3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/demo", method = RequestMethod.GET)
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello");
	}

	@RequestMapping(value = "/demo/{name}", method = RequestMethod.POST)
	public ResponseEntity<String> sayHello(@PathVariable String name) {
		return ResponseEntity.ok("Hello, " + name);
	}

}
