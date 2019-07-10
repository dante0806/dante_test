package com.dante.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing		// JPA Auditing 활성화
@SpringBootApplication
public class DanteApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(DanteApplication.class, args);
		SpringApplication app = new SpringApplication(DanteApplication.class);
		
		app.run(args);
	}

}
