package com.bcp.monitoring.MIMApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"controller", "service", "repository", "entity", "dto", "mapper", "com.bcp.monitoring.MIMApp"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")

public class MimAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MimAppApplication.class, args);
	}

}
