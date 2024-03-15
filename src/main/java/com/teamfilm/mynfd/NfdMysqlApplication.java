package com.teamfilm.mynfd;

import com.teamfilm.mynfd.config.AppConstants;
import com.teamfilm.mynfd.persistence.user.RoleEntity;
import com.teamfilm.mynfd.persistence.user.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

// (exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class NfdMysqlApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(NfdMysqlApplication.class, args);
		System.out.println("nfd started");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}


	@Override
	public void run(String... args) throws Exception {
		try {
			RoleEntity role1 = new RoleEntity();
			role1.setId(AppConstants.ROLE_ADMIN);
			role1.setName("ROLE_ADMIN");

			RoleEntity role2 = new RoleEntity();
			role2.setId(AppConstants.ROLE_USER);
			role2.setName("ROLE_USER");

			List<RoleEntity> roles = List.of(role1, role2);

			List<RoleEntity> result = roleRepository.saveAll(roles);

			result.forEach(r -> System.out.println(r.getName()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
