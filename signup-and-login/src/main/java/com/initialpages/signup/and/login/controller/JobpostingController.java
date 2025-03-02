package com.initialpages.signup.and.login.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
	public ResponseEntity<List<JobPostings>> getJobsForEmployer() {
        List<JobPostings> jobs = ser.getJobsForEmployer();
        return ResponseEntity.ok(jobs);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@PostMapping("/postings")
	public ResponseEntity<JobPostings> postJob(@RequestBody JobPostings jobPosting) {
        JobPostings savedJob = ser.postJob(jobPosting);
        return ResponseEntity.ok(savedJob);
    }

	
}
