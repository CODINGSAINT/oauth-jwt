package com.codingsaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingsaint.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}