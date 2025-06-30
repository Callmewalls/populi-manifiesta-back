package com.example.Auth.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Auth.interfaces.Credentials;
import com.example.Auth.services.AuthService;
import com.example.demo.models.ApiResponseError;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@EnableAutoConfiguration
@RequestMapping("/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    @Operation(summary = "Login endpoint", description = "Allows the user to log in with email and password.", operationId = "login")
    @ApiResponses(value = {
        @ApiResponse
        (
            responseCode = "200", content = {@Content(mediaType = "text/plain")}
        )
    })
    public String login(@Valid @RequestBody Credentials credentials){

        String token = this.authService.login(credentials.getEmail(), credentials.getPassword());

        if(token != null){
            return token;
        }
        else {
            ApiResponseError error = new ApiResponseError();

            error.setError("Unauthorized");
            error.setStatusCode(401);
            error.setMessage("Email or password are incorrect");

            return  error.getMessage();
        }


    }
}
