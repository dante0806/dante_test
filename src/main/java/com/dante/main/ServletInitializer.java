package com.dante.main;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//톰켓을 통해 배포하는 경우, SpringBootServletInitializer를 상속받은 클래스가 필요!
public class ServletInitializer extends SpringBootServletInitializer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(DanteApplication.class);
	}
}
