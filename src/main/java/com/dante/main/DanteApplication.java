package com.dante.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.dante.main.common.FileUploadProperties;

@EnableConfigurationProperties({	//FileUploadProperties 와 yml을 연결하기 위해 사용.
	FileUploadProperties.class
})
@EnableJpaAuditing		// JPA Auditing 활성화
@SpringBootApplication
public class DanteApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(DanteApplication.class, args);
		SpringApplication app = new SpringApplication(DanteApplication.class);
		
		app.run(args);
	}

}
