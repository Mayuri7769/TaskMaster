package com.task.taskmanager.controller;
import com.task.taskmanager.entity.User;
import com.task.taskmanager.dto.LoginRequest;
import com.task.taskmanager.dto.RegisterRequest;
import com.task.taskmanager.dto.AuthResponse;
import com.task.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    // Register API
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        userService.register(request);

        return ResponseEntity.ok("User registered successfully");
    }


    // Login API
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        String token = userService.login(request);

        return ResponseEntity.ok(new AuthResponse("Login successful", token));
    }
}