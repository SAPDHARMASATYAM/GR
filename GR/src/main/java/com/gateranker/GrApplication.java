package com.gateranker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GrApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrApplication.class, args);
	}
}
