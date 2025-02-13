package com.initialpages.signup.and.login.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.initialpages.signup.and.login.model.JobPostings;

@Repository
public interface JobPostingrepository extends JpaRepository<JobPostings, Long>{
    List<JobPostings> findByEmployerEmail(String employerEmail); // Fetch jobs by employer's email

}

