package com.bootcamp.passiveaccounts.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class TypePassiveProduct {

	@Id
	private String idTypePassiveProduct;
	private String description;
	private String abbreviation;
	private String movementLimitIndicator;
	private Long maximunMovements;
	private Double maintenanceCommission;
	private Audit audit;
}
