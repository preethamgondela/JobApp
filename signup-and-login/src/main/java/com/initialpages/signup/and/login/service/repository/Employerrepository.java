package com.initialpages.signup.and.login.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.Users;

public interface Employerrepository extends JpaRepository<Employers, Long>{
	Employers findByEmail(String email);

}
