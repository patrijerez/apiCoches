package com.formacion.app.tareaCoche;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Api Coches", version = "1.0", description = "Crud completo coches"))
public class ApiCocheApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiCocheApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		String pass = "admin";
		for (int i = 0; i < 3; i++) {
			String passBcrypt = passwordEncoder.encode(pass);
			System.out.println(passBcrypt);
		}

	}
}
