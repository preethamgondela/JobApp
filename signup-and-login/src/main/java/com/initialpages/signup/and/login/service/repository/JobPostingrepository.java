package com.initialpages.signup.and.login.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initialpages.signup.and.login.model.JobPostings;

public interface JobPostingrepository extends JpaRepository<JobPostings, Long> {
}
