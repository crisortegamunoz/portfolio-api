package com.cristianortega.portfolio.web.controller;

import com.cristianortega.portfolio.domain.dto.LoginDTO;
import com.cristianortega.portfolio.service.security.ApiKeyService;
import com.cristianortega.portfolio.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final ApiKeyService apiKeyService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil,
                          ApiKeyService apiKeyService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.apiKeyService = apiKeyService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        if (authentication.isAuthenticated()) {
            final String JWT = this.jwtUtil.create(loginDTO.getUsername());
            final String API_KEY_CODE = this.apiKeyService.getApyKeyByUsername(loginDTO.getUsername());
            Map<String, String> map = new HashMap<>(0);
            map.put("jwt", JWT);
            map.put("apiKey", API_KEY_CODE);
            return new ResponseEntity<>(map, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

}
