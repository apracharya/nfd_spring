package com.teamfilm.mynfd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class NfdMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfdMysqlApplication.class, args);
		System.out.println("nfd started");
	}

}
