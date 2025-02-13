package com.initialpages.signup.and.login.controller;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.initialpages.signup.and.login.model.Organization;
import com.initialpages.signup.and.login.model.Role;
import com.initialpages.signup.and.login.model.Users;
import com.initialpages.signup.and.login.service.Employerservice;
import com.initialpages.signup.and.login.service.Userservice;
import com.initialpages.signup.and.login.service.repository.Employerrepository;
import com.initialpages.signup.and.login.service.repository.Organizationrepository;
import com.initialpages.signup.and.login.service.repository.Userrepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class Inicontroller {
	
	@Autowired
	Userrepository rep;
	@Autowired
	Employerrepository rep1;
	
	@Autowired
	Organizationrepository organizationRepository;
	
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
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@PostMapping("/check-email")
	public ResponseEntity<Map<String, Object>> checkEmail(@RequestBody Map<String, Object> emp) {
		String employerDomain = ((String) emp.get("email"));
		employerDomain=employerDomain.split("@")[1];
        Organization existingOrganization = organizationRepository.findByOrganizationDomain(employerDomain);
        Map<String, Object> response = new HashMap<>();
	    // Check if the email exists in the employer database
	    if(existingOrganization!=null) {
	    	System.out.println(employerDomain);
	    	response.put("emailExists", true);
	    	}
	    else response.put("emailExists", false);

	    return ResponseEntity.ok(response);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@PostMapping("/employers")
    public String submitForm(@RequestBody Map<String, Object> emp) {
//		emp.setEntryDate(LocalDateTime.now());
//    	emp.setUpdateDate(LocalDateTime.now());
		
        eservice.submitForme(emp);
        return "Registration successfull";
    }
	
	@GetMapping("/users")
	public List<Users> getUsers(){
		return service.getUsers();
	}
    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method

	@PostMapping("/users")
    public ResponseEntity<Users> submitForm(@RequestBody Users user) {
    	user.setEntryDate(LocalDateTime.now());
    	user.setUpdateDate(LocalDateTime.now());
        Users user1 = service.submitForm(user);
//        System.out.println(user1.getJobtitle());
        return ResponseEntity.ok(user1);
    }
    
    
    @CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
//        boolean isAuthenticated = service.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
        Role role = loginRequest.getRole();
        System.out.println(role.name());
        if (role.name().equals("APPLICANT")) {
        	Users user = rep.findByEmail(loginRequest.getEmail());
        	//        System.out.println(loginRequest.getRole());
        	if (user.getPassword().equals(loginRequest.getPassword())) {
        		return ResponseEntity.ok("Login successful");
        	} else {
        		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        	}
        }
        else {
        	Employers emp = rep1.findByEmail(loginRequest.getEmail());
            if (emp.getPassword().equals(loginRequest.getPassword())) {
            	session.setAttribute("employerEmail", loginRequest.getEmail());
        		String employermail = (String) session.getAttribute("employerEmail");
            	System.out.println("Employer email from session: " + employermail);
            	System.out.println("Employer sessionid is: " + session.getId());
        	    
        		return ResponseEntity.ok("Login successful");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        }
    }
}
