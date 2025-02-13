package com.initialpages.signup.and.login.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.initialpages.signup.and.login.model.Employers;
import com.initialpages.signup.and.login.model.Organization;
import com.initialpages.signup.and.login.model.Users;

public interface Organizationrepository extends JpaRepository<Organization, Long>{
	 Organization findByOrganizationDomain(String domain);
}
