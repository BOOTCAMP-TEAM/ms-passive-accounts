package com.bootcamp.passiveaccounts.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class PassiveAccounts {

	@Id
	private String idPassiveAccounts;
	private String accountNumber;
	private String idClient;
	private TypePassiveProduct typePassiveProduct;
	private Double accountingBalanceAmount ;
	private Double availableBalanceAmount;
	private Double interest;
	private Double commission;
	private Integer lastCorrelativeMovement;
	private String uniqueDateIndicator;
	private Date uniqueDate;
	private Audit audit;
}
