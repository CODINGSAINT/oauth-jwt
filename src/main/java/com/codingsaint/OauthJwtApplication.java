package com.codingsaint;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class OauthJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthJwtApplication.class, args);
	}
}
