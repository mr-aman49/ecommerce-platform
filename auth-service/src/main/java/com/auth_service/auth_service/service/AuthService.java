package com.auth_service.auth_service.service;

import com.auth_service.auth_service.model.AuthRequest;
import com.auth_service.auth_service.model.AuthResponse;
import com.auth_service.auth_service.model.UserCredential;
import com.auth_service.auth_service.repository.UserCredentialRepository;
import com.auth_service.auth_service.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserCredentialRepository repository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponse register(AuthRequest request) {
        Optional<UserCredential> existing = repository.findByEmail(request.getEmail());
        if (existing.isPresent()) {
            return new AuthResponse("Email already registered", false);
        }

        UserCredential credential = new UserCredential();
        credential.setEmail(request.getEmail());
        credential.setPassword(passwordEncoder.encode(request.getPassword()));
        repository.save(credential);

        return new AuthResponse("User registered successfully", true);
    }

    public AuthResponse login(AuthRequest request) {
        Optional<UserCredential> userOpt = repository.findByEmail(request.getEmail());
        if (userOpt.isEmpty()) {
            return new AuthResponse("Invalid credentials", false);
        }

        UserCredential user = userOpt.get();
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail());
            return new AuthResponse("Bearer " + token, true);
        } else {
            return new AuthResponse("Invalid credentials", false);
        }
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}