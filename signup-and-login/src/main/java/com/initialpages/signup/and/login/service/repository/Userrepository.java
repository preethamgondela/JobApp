package com.initialpages.signup.and.login.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.initialpages.signup.and.login.model.Users;

@Repository
public interface Userrepository extends JpaRepository<Users, Long>{
//	Users findByUsername(String name); 
	Users findByEmail(String emailAddress);

}
