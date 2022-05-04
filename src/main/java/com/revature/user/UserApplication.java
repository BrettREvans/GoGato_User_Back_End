package com.revature.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "GoGato API", version = "1.0", description = "Users Information"))
@EnableEurekaClient
public class UserApplication {

	//view API at http://localhost:8000/gogato-openapi

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public BCrypt.Hasher getHasher()
	{
		return BCrypt.withDefaults();
	}
}
