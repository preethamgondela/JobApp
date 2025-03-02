package com.initialpages.signup.and.login.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "APPLICANT")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicantID")
    private Long applicantID;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "MiddleInitial")
    private String middleInitial;

    @Column(name = "email", nullable = false)  // Replaced EmailAddress with Email
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    @Column(name = "ExperienceLevel")
    private String experienceLevel;

    @Column(name = "JobPreference")
    private String jobPreference;

    @Column(name = "Education")
    private String education;

    @Column(name = "Entry_Date", updatable = false)
    private LocalDateTime entryDate;

    @Column(name = "Entry_User", updatable = false)
    private String entryUser;

    @Column(name = "Update_Date")
    private LocalDateTime updateDate;

    @Column(name = "Update_User")
    private String updateUser;
    
    private String Role;

    
    public Users(Long applicantID, String firstName, String lastName, String middleInitial, String email,
			String password, String mobileNumber, String experienceLevel, String jobPreference, String education,
			LocalDateTime entryDate, String entryUser, LocalDateTime updateDate, String updateUser, String role) {
		super();
		this.applicantID = applicantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.experienceLevel = experienceLevel;
		this.jobPreference = jobPreference;
		this.education = education;
		this.entryDate = entryDate;
		this.entryUser = entryUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		Role = role;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	// Getters and Setters for all fields
    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
        this.applicantID = applicantID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getJobPreference() {
        return jobPreference;
    }

    public void setJobPreference(String jobPreference) {
        this.jobPreference = jobPreference;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
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

	@Override
	public String toString() {
		return "Users [applicantID=" + applicantID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleInitial=" + middleInitial + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", experienceLevel=" + experienceLevel + ", jobPreference=" + jobPreference
				+ ", education=" + education + ", entryDate=" + entryDate + ", entryUser=" + entryUser + ", updateDate="
				+ updateDate + ", updateUser=" + updateUser + ", Role=" + Role + "]";
	}

	public Users() {
//		super();
		// TODO Auto-generated constructor stub
	}

	
    
}
