package com.bootcamp.passiveaccounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.passiveaccounts.entity.TypePassiveProduct;
import com.bootcamp.passiveaccounts.service.TypePassiveProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/typePassiveProduct")
public class TypePassiveProductController {
	
	@Autowired
	private TypePassiveProductService service;
	
	@GetMapping
	public Flux<TypePassiveProduct> getAll() {
		return service.findAll();
	}
	
	@PostMapping
	public Mono<TypePassiveProduct> createTypePassiveProduct(@RequestBody TypePassiveProduct typePassiveProduct) {
		return service.save(typePassiveProduct);
	}
	
}
