package com.initialpages.signup.and.login.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class JobPostings {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String title;
	private String description;
	private String location;
	
	private String employerEmail;
	
	

	public String getEmployerEmail() {
		return employerEmail;
	}


	public void setEmployerEmail(String employerEmail) {
		this.employerEmail = employerEmail;
	}


	public JobPostings(int id, String title, String description, String location) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
	}
	
	
	@Override
	public String toString() {
		return "JobPostings [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", employerEmail=" + employerEmail + "]";
	}
	public JobPostings() {

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	

}
