package com.initialpages.signup.and.login.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORGANIZATION")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrganizationID")
    private Long organizationID;  // Primary Key, auto-generated

    @Column(name = "OrganizationDomain", nullable = false, unique = true)
    private String organizationDomain;  // Domain of the organization

    @Column(name = "OrganizationName", nullable = false)
    private String organizationName;  // Name of the organization

    @Column(name = "OrganizationType")
    private String organizationType;  // Type of organization (Non-profit, For-profit, Government)

    @Column(name = "AddressLine1")
    private String addressLine1;

    @Column(name = "AddressLine2")
    private String addressLine2;  // Optional field

    @Column(name = "City", nullable = false)
    private String city;

    @Column(name = "State", nullable = false)
    private String state;

    @Column(name = "Zip", nullable = false)
    private String zip;

    @Column(name = "Entry_Date", updatable = false)
    private LocalDateTime entryDate;

    @Column(name = "Entry_User", updatable = false)
    private String entryUser;

    @Column(name = "Update_Date")
    private LocalDateTime updateDate;

    @Column(name = "Update_User")
    private String updateUser;

    // Getters and Setters
    public Long getOrganizationID() {
        return organizationID;
    }

    public void setOrganizationID(Long organizationID) {
        this.organizationID = organizationID;
    }

    public String getOrganizationDomain() {
        return organizationDomain;
    }

    public void setOrganizationDomain(String organizationDomain) {
        this.organizationDomain = organizationDomain;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
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
        return "Organization [organizationID=" + organizationID + ", organizationDomain=" + organizationDomain
                + ", organizationName=" + organizationName + ", organizationType=" + organizationType + ", addressLine1="
                + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state + ", zip="
                + zip + ", entryDate=" + entryDate + ", entryUser=" + entryUser + ", updateDate=" + updateDate
                + ", updateUser=" + updateUser + "]";
    }

	public Organization(Long organizationID, String organizationDomain, String organizationName,
			String organizationType, String addressLine1, String addressLine2, String city, String state, String zip,
			LocalDateTime entryDate, String entryUser, LocalDateTime updateDate, String updateUser) {
		super();
		this.organizationID = organizationID;
		this.organizationDomain = organizationDomain;
		this.organizationName = organizationName;
		this.organizationType = organizationType;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.entryDate = entryDate;
		this.entryUser = entryUser;
		this.updateDate = updateDate;
		this.updateUser = updateUser;
	}

	public Organization() {
//		super();
		// TODO Auto-generated constructor stub
	}
    
}
