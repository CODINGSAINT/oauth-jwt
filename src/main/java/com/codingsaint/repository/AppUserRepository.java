package com.codingsaint.repository;

import org.springframework.data.repository.CrudRepository;

import com.codingsaint.model.AppUser;
 
public interface AppUserRepository extends CrudRepository<AppUser, Long>{
	AppUser findByUsername(String username);

}
