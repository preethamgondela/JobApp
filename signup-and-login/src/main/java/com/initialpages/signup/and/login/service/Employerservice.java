package com.initialpages.signup.and.login.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.Organization;
import com.initialpages.signup.and.login.model.Use;
import com.initialpages.signup.and.login.service.repository.Employerrepository;
import com.initialpages.signup.and.login.service.repository.Organizationrepository;
import com.initialpages.signup.and.login.service.repository.Userepository;
import com.initialpages.signup.and.login.util.EmailService;

import jakarta.mail.MessagingException;

@Service
public class Employerservice {
	
	@Autowired
	Employerrepository erepo;
	
	@Autowired
	Organizationrepository organizationRepository;
	
	@Autowired
	Userepository rr;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	BCryptPasswordEncoder pass;
	
	public List<Employers> getEmployers() {
		
		return erepo.findAll();
	}
	public void submitForme(Map<String , Object> emp) {
        // Extract domain from employer email
        String employerDomain = ((String) emp.get("email")).split("@")[1];

        // Check if the domain exists in the Organization table
        Organization existingOrganization = organizationRepository.findByOrganizationDomain(employerDomain);
        String firstName = (String) emp.get("firstName");
        String lastName = (String) emp.get("lastName");
        String middleInitial = (String) emp.get("middleInitial");
        String email = (String) emp.get("email");
        String password = (String) emp.get("password");
        String mobileNumber = (String) emp.get("mobileNumber");
        String employerPosition = (String) emp.get("employerPosition");
        
        
        if (existingOrganization != null) {
        	Employers employer = new Employers();
        	Use u = new Use();
        	employer.setFirstName(firstName);
            employer.setLastName(lastName);
            employer.setMiddleInitial(middleInitial);
            employer.setEmail(email);
            employer.setMobileNumber(mobileNumber);
            employer.setPassword(pass.encode(password));
            employer.setEmployerPosition(employerPosition);
        	employer.setOrganization(existingOrganization);
        	employer.setRole("ROLE_EMPLOYER");
        	u.setEmail(email);
        	u.setPassword(pass.encode(password));
        	u.setRole("ROLE_EMPLOYER");
        	rr.save(u);
        	erepo.save(employer);
        	System.out.println("No need organization as it is already present");
        	sendVerificationEmail(employer);

        } else {
        	String organizationName = (String) emp.get("organizationName");
            String organizationType = (String) emp.get("organizationType");
            String addressLine1 = (String) emp.get("addressLine1");
            String addressLine2 = (String) emp.get("addressLine2");
            String city = (String) emp.get("city");
            String state = (String) emp.get("state");
            String zip = (String) emp.get("zip");
            
            Organization newOrganization = new Organization();
            newOrganization.setOrganizationDomain(employerDomain);
            newOrganization.setOrganizationName(organizationName);
            newOrganization.setOrganizationType(organizationType);
            newOrganization.setAddressLine1(addressLine1);
            newOrganization.setAddressLine2(addressLine2);
            newOrganization.setCity(city);
            newOrganization.setState(state);
            newOrganization.setZip(zip);
            organizationRepository.save(newOrganization);
            System.out.println("Need both organization and employer as the domain is new one");
            Employers employer = new Employers();
            Use u = new Use();
            employer.setFirstName(firstName);
            employer.setLastName(lastName);
            employer.setMiddleInitial(middleInitial);
            employer.setEmail(email);
            employer.setMobileNumber(mobileNumber);
            employer.setPassword(pass.encode(password));
            employer.setEmployerPosition(employerPosition);
            employer.setOrganization(newOrganization);
            employer.setRole("ROLE_EMPLOYER");
            u.setEmail(email);
        	u.setPassword(pass.encode(password));
        	u.setRole("ROLE_EMPLOYER");
        	rr.save(u);
            erepo.save(employer);
            sendVerificationEmail(employer);
        }
	}
//	private Organization createNewOrganization(String employerDomain, Employers employer) {
//        Organization organization = new Organization();
//        organization.setOrganizationDomain(employerDomain);
//        organization.setOrganizationName("New Company for " + employerDomain);
//        organization.setOrganizationType("For-profit");
//        organization.setAddressLine1("Address");
//        System.out.println("state is" +organization.getState());
//        organization.setCity("City");
//        organization.setState("State");
//        organization.setZip("Zip");
//        return organization;
//    }

    private void sendVerificationEmail(Employers employer) {
    	String subject = "Employer Registration Confirmation";
        String content = "Thank you for registering as an employer. Please confirm your registration.";
        try {
            emailService.sendVerificationEmail(employer.getEmail(), subject, content);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	

}
