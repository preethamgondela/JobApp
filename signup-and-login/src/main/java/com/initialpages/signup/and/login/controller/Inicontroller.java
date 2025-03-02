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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.initialpages.signup.and.login.config.CustomUser;
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
@CrossOrigin
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
    
	
	@GetMapping("/user/email")
    public String getUserEmail() {
        // Get the Authentication object from the SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Get the User object (which contains user details like username, email, etc.)
        CustomUser user = (CustomUser) authentication.getPrincipal();
        
        // Assuming the user's email is stored as the username or a custom field
        String email = user.getUsername();  // Or user.getEmail() if custom field
        
        return "The logged-in user's email is: " + email + " And the role is " + user.getAuthorities();
    }
	
//	@GetMapping("/employer/email")
//    public String getEmpEmail() {
//        // Get the Authentication object from the SecurityContext
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        
//        // Get the User object (which contains user details like username, email, etc.)
//        CustomEmployer user = (CustomEmployer) authentication.getPrincipal();
//        
//        // Assuming the user's email is stored as the username or a custom field
//        String email = user.getUsername();  // Or user.getEmail() if custom field
//        
//        return "The logged-in user's email is: " + email + " And the role is " + user.getAuthorities();
//    }


	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@PostMapping("/users")
    public ResponseEntity<Users> submitForm(@RequestBody Users user) {
    	user.setEntryDate(LocalDateTime.now());
    	user.setUpdateDate(LocalDateTime.now());
    	user.setRole("ROLE_USER");
        Users user1 = service.submitForm(user);
//        System.out.println(user1.getJobtitle());
        return ResponseEntity.ok(user1);
    }
    
    
	 	@Autowired
	    private AuthenticationManager authenticationManager;

	 	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	    @PostMapping("/login")
	    public String login(@RequestBody LoginRequest logg) {
	        // Create the authentication token
	        UsernamePasswordAuthenticationToken authenticationToken =
	                new UsernamePasswordAuthenticationToken(logg.getEmail(), logg.getPassword());

	        // Authenticate the user using the AuthenticationManager
	        Authentication authentication = authenticationManager.authenticate(authenticationToken);

	        // Set the authentication in the SecurityContext
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // Return a success message or token (e.g., JWT token if using JWT)
	        String s = logg.getEmail();
	        return "Login successful! "+s;
	    }

//	    @PostMapping("/logout")
//	    public String logout() {
//	        // Clear the security context to log out the user
//	        SecurityContextHolder.clearContext(); // Clears the user from the context
//	        
//	        // Any additional logout logic can go here (e.g., token invalidation)
//
//	        return "Logged out successfully!";
//	    }

	    
	    
//	    @PostMapping("/logine")
//	    public String login(@RequestBody LoginRequest logg) {
//	        // Create the authentication token
//	        UsernamePasswordAuthenticationToken authenticationToken =
//	                new UsernamePasswordAuthenticationToken(logg.getEmail(), logg.getPassword());
//
//	        // Authenticate the user using the AuthenticationManager
//	        Authentication authentication = authenticationManager.authenticate(authenticationToken);
//
//	        // Set the authentication in the SecurityContext
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	        // Return a success message or token (e.g., JWT token if using JWT)
//	        return "Login successful!";
//	    }


}