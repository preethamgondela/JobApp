//package com.initialpages.signup.and.login.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//import com.initialpages.signup.and.login.model.LoginRequest;
//import com.initialpages.signup.and.login.service.MyUserDetailsService;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;  // To handle authentication
//    
//    @Autowired
//    private MyUserDetailsService userDetailsService; // To validate user details
//    
//    
//
//    @PostMapping
//    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
//    	
//    	try {
//            // Fetch user from DB (this is where validatePassword will be used)
//            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());
//
//            // Use the validatePassword method to check if the entered password matches the stored one
//            if (userDetailsService.validatePassword(loginRequest.getPassword(), userDetails.getPassword())) {
//                Authentication authentication = authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                loginRequest.getEmail(),
//                                loginRequest.getPassword()
//                        )
//                );
//
//                // Set the authentication in the security context
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//
//                return ResponseEntity.ok("Login successful!");
//            } else {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password.");
//            }
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password.");
//        }
//    }
// }
