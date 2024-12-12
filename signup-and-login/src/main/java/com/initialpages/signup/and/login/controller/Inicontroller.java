package com.initialpages.signup.and.login.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.Http2;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.LoginRequest;
import com.initialpages.signup.and.login.model.Users;
import com.initialpages.signup.and.login.service.Employerservice;
import com.initialpages.signup.and.login.service.Userservice;
import com.initialpages.signup.and.login.service.repository.Userrepository;

@RestController
@RequestMapping("/api")
public class Inicontroller {
	
	@Autowired
	Userrepository rep;
	
	@Autowired
	Userservice service;
	@Autowired
	Employerservice eservice;
	
	@RequestMapping("/")
	public String greet() {
		return "Hi Hello";
	}
	@GetMapping("/employers")
	public List<Employers> getEmployers(){
		return eservice.getEmployers();
	}
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method

	@PostMapping("/users")
    public ResponseEntity<Users> submitForm(@RequestBody Users user) {
        Users user1 = service.submitForm(user);
        return ResponseEntity.ok(user1);
    }
    
    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//        boolean isAuthenticated = service.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        Users user = rep.findByEmail(loginRequest.getEmail());
        if (user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}
