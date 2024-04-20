package com.argumentresolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argumentresolver.model.Client;
import com.argumentresolver.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {



}
