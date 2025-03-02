package com.initialpages.signup.and.login.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Use {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "ApplicantID")
    private Long aID;
	private String email;
	private String password;
	private String Role;
	public Long getaID() {
		return aID;
	}
	public void setaID(Long aID) {
		this.aID = aID;
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
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "Use [aID=" + aID + ", email=" + email + ", password=" + password + ", Role=" + Role + "]";
	}
	public Use(Long aID, String email, String password, String role) {
		super();
		this.aID = aID;
		this.email = email;
		this.password = password;
		Role = role;
	}
	public Use() {
		//super();
		// TODO Auto-generated constructor stub
	}
	

}
