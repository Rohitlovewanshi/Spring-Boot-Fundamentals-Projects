package com.rohit.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.springcloud.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
	

}
