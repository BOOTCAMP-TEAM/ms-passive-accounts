package com.bootcamp.passiveaccounts.service;

import com.bootcamp.passiveaccounts.entity.TypePassiveProduct;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypePassiveProductService {

	public Flux<TypePassiveProduct> findAll();
	
	public Mono<TypePassiveProduct> findById(String id);
	
	public Mono<TypePassiveProduct> save(TypePassiveProduct typePassiveProduct);
	
	public Mono<Void> delete(TypePassiveProduct typePassiveProduct);
}
