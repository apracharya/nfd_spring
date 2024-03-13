package com.teamfilm.mynfd;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

// (exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class NfdMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(NfdMysqlApplication.class, args);
		System.out.println("nfd started");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
