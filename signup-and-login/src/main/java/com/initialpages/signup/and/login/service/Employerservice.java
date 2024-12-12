package com.initialpages.signup.and.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.service.repository.Employerrepository;

@Service
public class Employerservice {
	
	@Autowired
	Employerrepository erepo;
	public List<Employers> getEmployers() {
		
		return erepo.findAll();
	}
	

}
