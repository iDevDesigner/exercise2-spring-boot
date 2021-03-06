package com.idd.springboot.crudapp.restController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idd.springboot.crudapp.entity.Product;
import com.idd.springboot.crudapp.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/")
	public String sayHello() {

		return "hello";
	}

	// add mapping for GET /products
	@GetMapping("/products")
	public List<Product> getCustomers() {

		return productService.getProducts();

	}

	// add mapping for GET /products/{produtId}

	@GetMapping("/products/{produtId}")
	public ResponseEntity<?> getCustomer(@PathVariable int produtId) {

		try {
			Product theProduct = productService.getProduct(produtId);

			if (theProduct != null) {
				return ResponseEntity.status(HttpStatus.OK).body(theProduct);

			} else {
				productService.deleteProduct(produtId);
				Map<String, String> errors = new LinkedHashMap<>();
				errors.put("status", "404");
				errors.put("error", "Not Found");
				errors.put("message", "No Product Available in this ID: " + produtId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

			}

		} catch (Exception e) {

			productService.deleteProduct(produtId);
			Map<String, String> errors = new LinkedHashMap<>();
			errors.put("status", "404");
			errors.put("error", "Not Found");
			errors.put("message", "No Product Available in this ID: " + produtId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

		}
	}

	// add mapping for DELETE /products/{produtId} - delete product

	@DeleteMapping("/products/{produtId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int produtId) {

		Product tempProd = productService.getProduct(produtId);

		// Handling null condition
		if (tempProd != null) {
			productService.deleteProduct(produtId);
			return ResponseEntity.status(HttpStatus.OK).body("Product Deleted Successfully!");

		} else {
			productService.deleteProduct(produtId);
			Map<String, String> errors = new LinkedHashMap<>();
			errors.put("status", "404");
			errors.put("error", "Not Found");
			errors.put("message", "No Product Available in this ID: " + produtId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);

		}
	}

}
