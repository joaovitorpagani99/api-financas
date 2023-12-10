package com.dev.despesa.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.despesa.model.DTO.AutheticationDTO;

@RestController
@RequestMapping("/auth")
public class AutheticationController {

    public ResponseEntity login(@RequestBody AutheticationDTO data) {
        return null;
    }
}
