package com.initialpages.signup.and.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.initialpages.signup.and.login.model.JobPostings;
import com.initialpages.signup.and.login.service.repository.JobPostingrepository;

@Service
public class JobPostingservice {
	
	@Autowired
	JobPostingrepository r;

	public List<JobPostings> getJobs() {	
		return r.findAll();
	}

	public JobPostings postDetails(JobPostings job) {
		return r.save(job);
	}

	
}
