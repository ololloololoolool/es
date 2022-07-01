package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibreriaV2Application /*extends SpringBootServletInitializer*/{

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(LibreriaV2Application.class);
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(LibreriaV2Application.class, args);
	}

}
