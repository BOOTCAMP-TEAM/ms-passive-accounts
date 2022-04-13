package com.bootcamp.passiveaccounts.bean;

import java.util.Date;

import lombok.Data;

@Data
public class Audit {
	
	private String registrationStatus;
	private String creationUser;
	private Date creationDate;
	private String creationTerminal;
	private String modificationUser;
	private Date modificationDate;
	private String modificationTerminal;
	
	
}
