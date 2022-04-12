package com.bootcamp.passiveaccounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.passiveaccounts.entity.TypePassiveProduct;

@Repository
public interface TypePassiveProductRepository extends ReactiveMongoRepository<TypePassiveProduct, String> {

}
