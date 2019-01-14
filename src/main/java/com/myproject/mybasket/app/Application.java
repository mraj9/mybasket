package com.myproject.mybasket.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.myproject.mybasket.controller.UserDetailsController;


@SpringBootApplication(scanBasePackages={
		"com.myproject.mybasket"})
@EntityScan("com.myproject.mybasket.user")
@EnableJpaRepositories("com.myproject.mybasket.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

