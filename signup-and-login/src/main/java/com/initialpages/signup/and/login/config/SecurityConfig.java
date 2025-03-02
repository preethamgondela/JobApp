package com.initialpages.signup.and.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http.
    			csrf().disable().
    			authorizeHttpRequests(auth -> {
    				auth.requestMatchers("/api/").permitAll();
    				auth.requestMatchers("/api/users").permitAll();
    				auth.requestMatchers("/api/employers").permitAll();
    				//auth.requestMatchers("/api/login").permitAll();
    				//auth.requestMatchers("/api/postings").permitAll();
    				//auth.requestMatchers("/api/logout").permitAll();
    				auth.anyRequest().authenticated();  
    			})
    			//.formLogin()  // Disable default form login provided by Spring Security
                .httpBasic(); // Optional: Disable HTTP Basic Authentication if not needed
          		
        
        return http.build();  // Return the configured HttpSecurity
    }
    
    @Bean
    public DaoAuthenticationProvider getauthprovider() {
    	DaoAuthenticationProvider authprovider = new DaoAuthenticationProvider();
    	authprovider.setUserDetailsService(myuserdetails());
    	authprovider.setPasswordEncoder(passwordEncoder());
    	return authprovider;
    }
    
    @Bean
    public UserDetailsService myuserdetails() {
    	return new CustomUserDetailsService();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt password encoder
    }

    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
    
   


}
