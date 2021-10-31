package com.rohit.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
