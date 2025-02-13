package com.initialpages.signup.and.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "EMPLOYER")
public class Employers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployerUserID")
    private Long employerUserID; // Primary Key, auto-generated

    @Column(name = "FirstName", nullable = false)  // Required field
    private String firstName;

    @Column(name = "LastName", nullable = false)  // Required field
    private String lastName;

    @Column(name = "MiddleInitial")
    private String middleInitial;  // Optional field

    @Column(name = "Email", nullable = false)  // Required field
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    @Column(name = "EmployerPosition")
    private String employerPosition;

    @Column(name = "Entry_Date", updatable = false)
    private LocalDateTime entryDate;

    @Column(name = "Entry_User", updatable = false)
    private String entryUser;

    @Column(name = "Update_Date")
    private LocalDateTime updateDate;

    @Column(name = "Update_User")
    private String updateUser;
    
    @ManyToOne
    @JoinColumn(name = "OrganizationID")
    private Organization organization;

    
    
    public Employers(Long employerUserID, String firstName, String lastName, String middleInitial, String email,
			String password, String mobileNumber, String employerPosition, LocalDateTime entryDate, String entryUser,
			LocalDateTime updateDate, String updateUser, Organization organization) {
		super();
		this.employerUserID = employerUserID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.employerPosition = employerPosition;
		this.entryDate = entryDate;
		this.entryUser = entryUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
		this.organization = organization;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	// Getters and Setters
    public Long getEmployerUserID() {
        return employerUserID;
    }

    public void setEmployerUserID(Long employerUserID) {
        this.employerUserID = employerUserID;
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

    public String getEmployerPosition() {
        return employerPosition;
    }

    public void setEmployerPosition(String employerPosition) {
        this.employerPosition = employerPosition;
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
		return "Employers [employerUserID=" + employerUserID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleInitial=" + middleInitial + ", email=" + email + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", employerPosition=" + employerPosition + ", entryDate=" + entryDate + ", entryUser="
				+ entryUser + ", updateDate=" + updateDate + ", updateUser=" + updateUser + ", organization="
				+ organization + "]";
	}

    // Default constructor
    public Employers() {}

}
