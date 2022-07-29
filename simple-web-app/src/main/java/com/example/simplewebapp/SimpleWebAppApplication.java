package com.example.simplewebapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication( scanBasePackages = {"com.example.simplewebapp"})
public class SimpleWebAppApplication {

	public static void main(String[] args) {
		run(args);
	}
	public static ConfigurableApplicationContext run(String... args) {
		return new SpringApplicationBuilder()
				.sources(SimpleWebAppApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.build()
				.run(args);
	}
}
