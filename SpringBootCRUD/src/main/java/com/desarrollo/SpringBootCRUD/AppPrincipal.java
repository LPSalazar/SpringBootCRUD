package com.desarrollo.SpringBootCRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /* esta anotacion engloba las anotaciones  @Configuration + @EnableAutoConfiguration + @ComponentScan */
public class AppPrincipal {

	public static void main(String[] args) {
		
		SpringApplication.run(AppPrincipal.class, args);/*SpringApplication.run, ,metodo de Spring Boot para iniciar aplicacion*/

	}

}
