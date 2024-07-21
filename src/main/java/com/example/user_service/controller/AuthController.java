package com.example.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user_service.config.JwtResponse;
import com.example.user_service.config.JwtUtil;
import com.example.user_service.model.LoginRequest;
import com.example.user_service.model.User;
import com.example.user_service.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            User user = userService.getUserByUsername(loginRequest.getUsername());
            if (user == null) {
                return ResponseEntity.status(401).body(new JwtResponse(401, "User does not exist"));
            }
            if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUsername());
                return ResponseEntity.ok(new JwtResponse(200, "Login successful", token));
            }
            return ResponseEntity.status(401).body(new JwtResponse(401, "Invalid credentials"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new JwtResponse(500, "Internal server error"));
        }
    }
}

