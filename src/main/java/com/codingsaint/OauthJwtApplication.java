package com.codingsaint;


import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import com.codingsaint.model.AppUser;
import com.codingsaint.model.Role;
import com.codingsaint.repository.AppUserRepository;
import com.codingsaint.repository.RoleRepository;

@SpringBootApplication
@EnableAuthorizationServer
public class OauthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthJwtApplication.class, args);
	}
	
	  @Bean
      CommandLineRunner init (RoleRepository roleRepo,AppUserRepository appUserRepo){
          return args -> { 
              Set<String> roles =new HashSet<>();
              roles.add("ADMIN");
              roles.add("USER"); 
              roles.forEach(role -> roleRepo.save(new Role(role)));
              AppUser user= new AppUser();
              PasswordEncoder encoder=new BCryptPasswordEncoder();
              user.setUsername("kumarpallav@kumarpallav.in");
              user.setPassword(encoder.encode("password"));
              Role role=roleRepo.findByName("ADMIN");
              Set<Role>userRoles=new HashSet<>();
              userRoles.add(role); 
              user.setRoles(userRoles);
              appUserRepo.save(user);
              
          };
      
  }
}
