package com.drodrigues17.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebfluxApplication {

	@Bean
	public WebProperties.Resources resources() {
		return new WebProperties.Resources();
	}


	public static void main(String[] args) {
		SpringApplication.run(WebfluxApplication.class, args);
	}

}
