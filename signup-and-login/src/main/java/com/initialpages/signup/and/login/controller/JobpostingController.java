package com.initialpages.signup.and.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.JobPostings;
import com.initialpages.signup.and.login.service.JobPostingservice;
import com.initialpages.signup.and.login.service.repository.Employerrepository;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class JobpostingController {
	
	@Autowired
	JobPostingservice ser;
	
	@Autowired
	Employerrepository rep;
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	@GetMapping("/postings")
	public List<JobPostings> getJobs(HttpSession session){
		String employerEmail = (String) session.getAttribute("employerEmail");
		Employers employer = rep.findByEmail(employerEmail);
		
//		List<JobPostings> jobs = ser.getJobs(employer.getId());
		
		return ser.getJobs();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")  // Allow CORS for this method
	
	@PostMapping("/postings")
	public ResponseEntity<JobPostings> postDetails(@RequestBody JobPostings job, HttpSession session){
		
		String employerEmail = (String) session.getAttribute("employerEmail");
		
		Employers employer = rep.findByEmail(employerEmail);
		
		job.setEmployerId(employer);
		JobPostings job1=ser.postDetails(job);
		return ResponseEntity.ok(job1);
		
	}
}
