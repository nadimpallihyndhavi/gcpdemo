package com.lntinfotech.demoapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lntinfotech.demoapplication.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	

}
