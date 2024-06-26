package com.argumentresolver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.argumentresolver.model.Client;

public interface ClientRepository  extends JpaRepository<Client,Integer>,  JpaSpecificationExecutor<Client> {

    
}
