package com.argumentresolver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.argumentresolver.model.Client;
import com.argumentresolver.repository.ClientRepository;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Client>> get(
			@And({ @Spec(path = "name", params = "name", spec = Like.class),
					@Spec(path = "email", params = "email", spec = Like.class),
					@Spec(path = "phoneNumber", params = "phoneNumber", spec = Equal.class),
					@Spec(path = "address", params = "address", spec = Like.class),
					@Spec(path = "dateOfBirth", params = "dateOfBirth", spec = Equal.class),
					}) Specification<Client> spec,
			Sort sort, @RequestHeader HttpHeaders headers) {
		
		return new ResponseEntity<>(clientRepository.findAll(spec),  HttpStatus.OK);

	}

}
	