package com.bootcamp.passiveaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsPassiveAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPassiveAccountsApplication.class, args);
	}

}
