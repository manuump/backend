package com.ociojaen.backend.controllers;

import com.ociojaen.backend.models.Rol;
import com.ociojaen.backend.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistroRequest req) {
        return ResponseEntity.ok(authService.registrar(req.username(), req.email(), req.password(), req.tipo()));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest req) {
        return ResponseEntity.ok(authService.login(req.username(), req.password()));
    }

    public record RegistroRequest(String username, String email, String password, Rol tipo) {}
    public record LoginRequest(String username, String password) {}
}