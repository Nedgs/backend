package com.example.lma;

import com.example.lma.model.Company;
import com.example.lma.model.Role;
import com.example.lma.model.User;
import com.example.lma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LmaApplication implements CommandLineRunner {

	@Autowired
	UserService userService;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(LmaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Company.class);
	}

//	@PostConstruct
//	void init_users() {
//		//ajouter les rôles
//		userService.addRole(new Role(null,"ADMIN"));
//		userService.addRole(new Role(null,"USER"));
//
//		//ajouter les users
//		userService.saveUser(new User(null,"admin","admin@gmail.com","123",true,null));
//		userService.saveUser(new User(null,"nadhem","nadhem@gmail.com","123",true,null));
//		userService.saveUser(new User(null,"yassine","yassine@gmail.com","123",true,null));
//
//		//ajouter les rôles aux users
//		userService.addRoleToUser("admin", "ADMIN");
//		userService.addRoleToUser("admin", "USER");
//		userService.addRoleToUser("nadhem", "USER");
//		userService.addRoleToUser("yassine", "USER");
//	}
	@Bean
	 BCryptPasswordEncoder getBCE() {
		return new  BCryptPasswordEncoder();
	}

}

