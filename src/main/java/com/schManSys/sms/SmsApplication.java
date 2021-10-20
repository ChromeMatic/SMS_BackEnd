package com.schManSys.sms;

import com.schManSys.sms.models.AppUser;
import com.schManSys.sms.models.Roles;
import com.schManSys.sms.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}

	/*
	* @Bean
	CommandLineRunner runner(UserService userService){
	  return args -> {

		userService.AddNewRole(new Roles(null,"ROLE_STUDENT"));
		userService.AddNewRole(new Roles(null,"ROLE_TEACHER"));
	    userService.AddNewRole(new Roles(null,"ROLE_STAFF"));
		userService.AddNewRole(new Roles(null,"ROLE_MANAGER"));
		userService.AddNewRole(new Roles(null,"ROLE_ADMIN"));

	    userService.AddNewUser(new AppUser(null,"armaniBrown","1234",new ArrayList<>()));
		userService.AddNewUser(new AppUser(null,"danielBrown","4141",new ArrayList<>()));
		userService.AddNewUser(new AppUser(null,"alexMason","2323",new ArrayList<>()));
		userService.AddNewUser(new AppUser(null,"johnBrown","2121",new ArrayList<>()));
		userService.AddNewUser(new AppUser(null,"patronJones","3131",new ArrayList<>()));
		  userService.AddNewUser(new AppUser(null,"developer","12345678",new ArrayList<>()));

		userService.AddRoleToUser("armaniBrown","ROLE_STUDENT");
		userService.AddRoleToUser("danielBrown","ROLE_STUDENT");
		userService.AddRoleToUser("alexMason","ROLE_TEACHER");
		userService.AddRoleToUser("alexMason","ROLE_STAFF");
		userService.AddRoleToUser("johnBrown","ROLE_TEACHER");
		userService.AddRoleToUser("johnBrown","ROLE_STAFF");
		userService.AddRoleToUser("patronJones","ROLE_MANAGER");
		userService.AddRoleToUser("developer","ROLE_ADMIN");

	  };
	}
	* */

}
