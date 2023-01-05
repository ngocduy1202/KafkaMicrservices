package com.clientrequest.clientrequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientrequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientrequestApplication.class, args);
	}

}
