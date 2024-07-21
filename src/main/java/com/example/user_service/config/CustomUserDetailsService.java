package com.example.user_service.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;

/**
 * ******************IMPORTANT*****************
 * 
 * CustomUserDetailsService is used to provide user details to the Spring Security context. 
 * This class implements UserDetailsService and overrides the loadUserByUsername method 
 * to retrieve user information from the UserRepository.
 * 
 * The use of CustomUserDetailsService helps avoid circular dependency issues that were 
 * encountered previously. By injecting UserRepository directly and handling user retrieval 
 * within this service, we prevent the circular dependency that occurred when 
 * JwtAuthenticationFilter and SecurityConfig depended on each other (And UserDetailsService comes in b/w them). 
 * This approach ensures that user details can be loaded without causing dependency loops 
 * in the security configuration.
 * (Revisit this later)
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
