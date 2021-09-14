package com.lntinfotech.demoapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lntinfotech.demoapplication.entity.Product;
import com.lntinfotech.demoapplication.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productApp")
@Api(value="ProductApplication")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/welcome")
	public String helloworld() {
		return "Hi, Welcome to sample DEMO project for GCP";
		
	}

	@PostMapping("/addProduct")
	@ApiOperation(value = "save the Product", response = Product.class)
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);

	}
	
	@PostMapping("/addProducts")
	@ApiOperation(value = "save the Products", response = Product.class)
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return service.saveAllProduct(products);

	}
	
	@GetMapping("/products")
    @ApiOperation(value = "View list of Products")
	public List<Product> findAllProducts(){
		return service.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value = "View Product by id")
	public Product findProductById(@PathVariable int id) {
		return service.getProductsById(id);
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "update Product")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Delete an Product")
	public String deleteProduct(@PathVariable int id) {
		
		return service.deleteProduct(id);
	}
}
