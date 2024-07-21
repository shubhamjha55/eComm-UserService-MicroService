package com.example.user_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user_service.model.User;
import com.example.user_service.model.UserRegisterationApiResponse;
import com.example.user_service.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity<UserRegisterationApiResponse> registerUser(User user) {
        try {
            if (userRepository.findByUsername(user.getUsername()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new UserRegisterationApiResponse("Username already exists, Please log in to your account!"));
            }
    
            if (userRepository.findByEmail(user.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new UserRegisterationApiResponse("User with specified email already exists"));
            }
    
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
    
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UserRegisterationApiResponse("You have registered successfully, Please log in to continue"));
    
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new UserRegisterationApiResponse("An error occurred while processing your registration request!"));
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
