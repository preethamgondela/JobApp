package com.initialpages.signup.and.login.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class JobPostings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobPostingId;

    private String jobTitle;
    private String jobDescription;
    private String jobPreferredSkills;
    private String jobType;
    private String location;
    private String jobPreference;
    private String salaryRange;
    private String experienceLevel;
    private String applicationDeadline;
    
    @ManyToOne
    @JoinColumn(name = "OrganizationID")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "EmployerUserID")
    private Employers employer;

    private String postResponseEmail;
    private LocalDateTime entryDate;
    private String entryUser;
    private LocalDateTime updateDate;
    private String updateUser;
	@Override
	public String toString() {
		return "JobPostings [jobPostingId=" + jobPostingId + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", jobPreferredSkills=" + jobPreferredSkills + ", jobType=" + jobType + ", location="
				+ location + ", jobPreference=" + jobPreference + ", salaryRange=" + salaryRange + ", experienceLevel="
				+ experienceLevel + ", applicationDeadline=" + applicationDeadline + ", organization=" + organization
				+ ", employer=" + employer + ", postResponseEmail=" + postResponseEmail + ", entryDate=" + entryDate
				+ ", entryUser=" + entryUser + ", updateDate=" + updateDate + ", updateUser=" + updateUser + "]";
	}
	public JobPostings(Long jobPostingId, String jobTitle, String jobDescription, String jobPreferredSkills,
			String jobType, String location, String jobPreference, String salaryRange, String experienceLevel,
			String applicationDeadline, Organization organization, Employers employer, String postResponseEmail,
			LocalDateTime entryDate, String entryUser, LocalDateTime updateDate, String updateUser) {
		super();
		this.jobPostingId = jobPostingId;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.jobPreferredSkills = jobPreferredSkills;
		this.jobType = jobType;
		this.location = location;
		this.jobPreference = jobPreference;
		this.salaryRange = salaryRange;
		this.experienceLevel = experienceLevel;
		this.applicationDeadline = applicationDeadline;
		this.organization = organization;
		this.employer = employer;
		this.postResponseEmail = postResponseEmail;
		this.entryDate = entryDate;
		this.entryUser = entryUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}
	public Long getJobPostingId() {
		return jobPostingId;
	}
	public void setJobPostingId(Long jobPostingId) {
		this.jobPostingId = jobPostingId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobPreferredSkills() {
		return jobPreferredSkills;
	}
	public void setJobPreferredSkills(String jobPreferredSkills) {
		this.jobPreferredSkills = jobPreferredSkills;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJobPreference() {
		return jobPreference;
	}
	public void setJobPreference(String jobPreference) {
		this.jobPreference = jobPreference;
	}
	public String getSalaryRange() {
		return salaryRange;
	}
	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	public String getApplicationDeadline() {
		return applicationDeadline;
	}
	public void setApplicationDeadline(String applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public Employers getEmployer() {
		return employer;
	}
	public void setEmployer(Employers employer) {
		this.employer = employer;
	}
	public String getPostResponseEmail() {
		return postResponseEmail;
	}
	public void setPostResponseEmail(String postResponseEmail) {
		this.postResponseEmail = postResponseEmail;
	}
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	public String getEntryUser() {
		return entryUser;
	}
	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public JobPostings() {
//		super();
		// TODO Auto-generated constructor stub
	}
	    
    
}
