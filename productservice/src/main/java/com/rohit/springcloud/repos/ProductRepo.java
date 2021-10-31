package com.rohit.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
