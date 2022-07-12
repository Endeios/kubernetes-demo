package com.example.initcontainer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfigurationPackage(basePackages = "com.example.initcontainer")
public class InitContainerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitContainerApplication.class, args);
	}


}
