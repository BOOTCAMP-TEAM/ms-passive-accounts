package com.bootcamp.passiveaccounts.entity;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Audit {
	
	private String registrationStatus;
	private String creationUser;
	private Date creationDate;
	private String creationTerminal;
	private String modificationUser;
	private Date modificationDate;
	private String modificationTerminal;
	
	
}
