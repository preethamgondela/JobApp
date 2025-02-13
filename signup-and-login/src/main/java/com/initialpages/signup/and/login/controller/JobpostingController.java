package com.initialpages.signup.and.login.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.JobPostings;
import com.initialpages.signup.and.login.service.JobPostingservice;
import com.initialpages.signup.and.login.service.repository.Employerrepository;
import com.initialpages.signup.and.login.service.repository.JobPostingrepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class JobpostingController {
	
	@Autowired
	JobPostingrepository r;
	
	@Autowired
	JobPostingservice ser;
	
	@Autowired
	Employerrepository rep;
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@GetMapping("/postings")
	public ResponseEntity<List<JobPostings>> getJobs(HttpSession session){
		String employerEmail = (String) session.getAttribute("employerEmail");
	    System.out.println("Employer email from session: " + employerEmail);
	    System.out.println("Employer sessionid is: " + session.getId());
	    
	    if (employerEmail == null) {
//	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You must be logged in as an employer.");
	    }
		
	    List<JobPostings> jobs = r.findByEmployerEmail(employerEmail); // Find jobs posted by this employer

//		List<JobPostings> jobs = ser.getJobs(employer.getId());
	    if (jobs.isEmpty()) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No jobs found for this employer.");
	    }

	    return ResponseEntity.ok(jobs);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	
	@PostMapping("/postings")
	public ResponseEntity<Map<String, String>> postDetails(@RequestBody JobPostings job, HttpSession session) {
	    // Get the employer's email from the session
	    String employerEmail = (String) session.getAttribute("employerEmail");

	    if (employerEmail == null) {
	        // Return a JSON response for forbidden access
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "You must be logged in as an employer.");
	        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
	    }

	    Employers employer = rep.findByEmail(employerEmail);

	    if (employer == null) {
	        // Return a JSON response for employer not found
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Employer not found.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }

	    // If employer is found, create a new job posting
	    JobPostings njob = new JobPostings();
	    njob.setTitle(job.getTitle());
	    njob.setDescription(job.getDescription());
	    njob.setLocation(job.getLocation());
	    njob.setEmployerEmail(employerEmail);  // Associate job with the employer's email

	    // Save the job posting
	    JobPostings job1 = ser.postDetails(njob);

	    // Return a success message as JSON
	    Map<String, String> response = new HashMap<>();
	    response.put("message", "Job posted successfully");
	    return ResponseEntity.ok(response);  // Return HTTP 200 OK with the success message
	}

	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        // Invalidate the session to log out the employer
		String employerEmail = (String) session.getAttribute("employerEmail");
	    System.out.println("logging out Employer email from session: " + employerEmail);
	    System.out.println("loggedout Employer sessionid is: " + session.getId());
	    
        session.invalidate();
        return ResponseEntity.ok("Logout successful");
    }
}
