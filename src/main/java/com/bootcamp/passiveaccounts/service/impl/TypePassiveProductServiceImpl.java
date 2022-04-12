package com.bootcamp.passiveaccounts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.passiveaccounts.entity.TypePassiveProduct;
import com.bootcamp.passiveaccounts.repository.TypePassiveProductRepository;
import com.bootcamp.passiveaccounts.service.TypePassiveProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TypePassiveProductServiceImpl implements TypePassiveProductService{

	@Autowired
	private TypePassiveProductRepository repository;
	
	@Override
	public Flux<TypePassiveProduct> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<TypePassiveProduct> save(TypePassiveProduct typePassiveProduct) {
		return repository.save(typePassiveProduct);
	}


}
