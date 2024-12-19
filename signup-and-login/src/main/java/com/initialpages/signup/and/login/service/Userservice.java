package com.initialpages.signup.and.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.Users;
import com.initialpages.signup.and.login.service.repository.Employerrepository;
import com.initialpages.signup.and.login.service.repository.Userrepository;


@Service
public class Userservice {

	@Autowired
	Userrepository repo;
	@Autowired
	Employerrepository repo1;
	
//	public Users addUserss(Users user) {
//		return repo.save(user);
//	}
	public List<Users> getUsers() {
		return repo.findAll();
		}
	public Users submitForm(Users user) {
		return repo.save(user);
	}
	public Employers submitForme(Employers emp) {
		return repo1.save(emp);
	}
	
//    public boolean authenticateUser(String email, String password) {
//        Users user = repo.findByEmail(email);
//
//        if (user != null && (password == user.getPassword())) {
//            return true;
//        }
//
//        return false;
//    }

}
