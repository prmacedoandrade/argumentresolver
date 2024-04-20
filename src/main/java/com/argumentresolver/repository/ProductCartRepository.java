package com.argumentresolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argumentresolver.model.ProductCart;

public interface ProductCartRepository extends JpaRepository<ProductCart, Integer> {
}
