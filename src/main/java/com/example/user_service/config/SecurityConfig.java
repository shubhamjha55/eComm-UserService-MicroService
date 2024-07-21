package com.example.user_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                // To be updated later
                .requestMatchers("/api/users/register").permitAll()
                .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("**").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf
                .disable() // Disable CSRF protection if needed
            )
            .formLogin(form -> form
                .disable() // Disable form login
            )
            .logout(logout -> logout
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
