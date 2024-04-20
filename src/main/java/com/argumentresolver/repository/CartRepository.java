package com.argumentresolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argumentresolver.model.Cart;
import com.argumentresolver.model.Client;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByClient(Client client);

}
