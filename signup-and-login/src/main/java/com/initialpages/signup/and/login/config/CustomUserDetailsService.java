package com.initialpages.signup.and.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.initialpages.signup.and.login.model.Use;
import com.initialpages.signup.and.login.model.Users;
import com.initialpages.signup.and.login.service.repository.Userepository;
import com.initialpages.signup.and.login.service.repository.Userrepository;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private Userepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Use user = rep.findByEmail(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("No user found with the given email");
		}
		else {
			return new CustomUser(user);
		}
		
	}

}
