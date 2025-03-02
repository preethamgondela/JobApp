package com.initialpages.signup.and.login.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.initialpages.signup.and.login.config.CustomUser;
import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.JobPostings;
import com.initialpages.signup.and.login.model.Use;
import com.initialpages.signup.and.login.service.repository.Employerrepository;
import com.initialpages.signup.and.login.service.repository.JobPostingrepository;

@Service
public class JobPostingservice {
	
	@Autowired
    private JobPostingrepository jobPostingsRepository;

    @Autowired
    private Employerrepository employersRepository;

    // Method to post a job
    public JobPostings postJob(JobPostings jobPosting) {
        // Get the currently authenticated employer
//        CustomUser userDetails = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Get the User object (which contains user details like username, email, etc.)
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        String username = userDetails.getUsername();
        
        // Find employer based on the username (assuming username is used to authenticate)
        Employers employer = employersRepository.findByEmail(username);
        
        // Set the employer to the job posting
        jobPosting.setEmployer(employer);
        jobPosting.setEntryDate(LocalDateTime.now());
        jobPosting.setEntryUser(username);
        System.out.println("Job is successfully posted for the logged in employer "+username);
        return jobPostingsRepository.save(jobPosting);
    }

    // Method to get all jobs posted by the authenticated employer
    public List<JobPostings> getJobsForEmployer() {
        // Get the currently authenticated employer
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        // Get the User object (which contains user details like username, email, etc.)
        CustomUser userDetails = (CustomUser) authentication.getPrincipal();
        String username = userDetails.getUsername();
        
        // Find employer based on the username
        Employers employer = employersRepository.findByEmail(username);
        
        System.out.println("The jobs are for the employer "+ username);
        
        // Return job postings for this employer
        return jobPostingsRepository.findByEmployer(employer);
    }
	
}
