package com.example.rest_api.controller;

import com.example.rest_api.dto.ApiResponse;
import com.example.rest_api.dto.AuthResponse;
import com.example.rest_api.model.User;
import com.example.rest_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(
            @Valid @RequestBody User user) {

        User registeredUser = authService.register(user);

        AuthResponse response = new AuthResponse(
                registeredUser.getId(),
                registeredUser.getName(),
                registeredUser.getEmail()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        "User registered successfully",
                        response
                ));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<AuthResponse>> login(
            @RequestBody LoginRequest request) {

        User user = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        AuthResponse response = new AuthResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Login successful",
                        response
                )
        );
    }

    public static class LoginRequest {

        private String email;
        private String password;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}