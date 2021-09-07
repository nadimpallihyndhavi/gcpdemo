package com.lntinfotech.demoapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lntinfotech.demoapplication.entity.Product;
import com.lntinfotech.demoapplication.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {

		return productRepository.save(product);

	}

	public List<Product> saveAllProduct(List<Product> products) {

		return productRepository.saveAll(products);

	}

	public List<Product> getAllProduct() {

		return productRepository.findAll();

	}

	public Product getProductsById(int id) {

		return productRepository.findById(id).orElse(null);

	}

	public String deleteProduct(int id) {

		productRepository.deleteById(id);
		return "product removed !" +id;
	}

	public Product updateProduct(Product product) {

		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		return productRepository.save(existingProduct);
	}

}
