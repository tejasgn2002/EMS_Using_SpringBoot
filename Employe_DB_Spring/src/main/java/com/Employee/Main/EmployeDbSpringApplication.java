package com.Employee.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.Employee")
@EntityScan(basePackages = "com.Employee.Bean")
@EnableJpaRepositories(basePackages = "com.Employee.Repository")
public class EmployeDbSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeDbSpringApplication.class, args);
	}

}
