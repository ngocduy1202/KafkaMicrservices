package com.dbcommunicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//@ComponentScan("com.dbcommunicate.consumer")
public class DbcommunicateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbcommunicateApplication.class, args);
	}

}
