package com.idd.springboot.crudapp.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	// add mapping for GET /products
	@GetMapping("/")
	public String index() {

		return "url patterns: \n 1- GET /api/products " + "\n" + "2- GET /api/products/{produtId} " + "\n"
				+ "3- DELETE /api/products/{produtId}";

	}

}
