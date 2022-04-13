package com.bootcamp.passiveaccounts.controller;

import java.net.URI;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Mono<ResponseEntity<Flux<TypePassiveProduct>>> getAll() {
		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll())
				);
	}
	
	@PostMapping
	public Mono<ResponseEntity<TypePassiveProduct>> createTypePassiveProduct(@RequestBody TypePassiveProduct typePassiveProduct) {
		if (typePassiveProduct.getAudit() != null) {
			if (typePassiveProduct.getAudit().getCreationDate() == null) {
				typePassiveProduct.getAudit().setCreationDate(new Date());;
			}
		}
		
		return service.save(typePassiveProduct).map(p-> ResponseEntity
				.created(URI.create("/typePassiveProduct/".concat(p.getIdTypePassiveProduct())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p)
				);
	}
	
	@PutMapping("/{id}")
	public Mono<ResponseEntity<TypePassiveProduct>> updateTypePassiveProduct(@RequestBody TypePassiveProduct typePassiveProduct, @PathVariable String id){
		return service.findById(id).flatMap(p -> {
			p.setDescription(typePassiveProduct.getDescription());
			p.setAbbreviation(typePassiveProduct.getAbbreviation());
			p.setMaintenanceCommission(typePassiveProduct.getMaintenanceCommission());
			p.setMaximunMovements(typePassiveProduct.getMaximunMovements());
			p.setMovementLimitIndicator(typePassiveProduct.getMovementLimitIndicator());
			p.getAudit().setModificationDate(typePassiveProduct.getAudit().getModificationDate());
			p.getAudit().setModificationUser(typePassiveProduct.getAudit().getModificationUser());
			p.getAudit().setModificationTerminal(typePassiveProduct.getAudit().getModificationTerminal());
			return service.save(p);
		}).map(p -> ResponseEntity.created(URI.create("/typePassiveProduct/".concat(p.getIdTypePassiveProduct())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(p))
		  .defaultIfEmpty(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> deleteTypePassiveProduct(@PathVariable String id){
		return service.findById(id).flatMap(p ->{
			return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}
	
}
