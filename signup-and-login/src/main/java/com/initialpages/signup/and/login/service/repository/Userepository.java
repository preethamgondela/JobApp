package com.initialpages.signup.and.login.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initialpages.signup.and.login.model.Use;

public interface Userepository extends JpaRepository<Use, Long>{
//	Users findByUsername(String name); 
	Use findByEmail(String email); 
}