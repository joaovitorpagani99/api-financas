package com.dev.despesa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.despesa.model.DTO.CriarUsuarioDTO;
import com.dev.despesa.model.DTO.LoginDTO;
import com.dev.despesa.model.DTO.RecoveryJwtTokenDto;
import com.dev.despesa.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutheticationController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDto> autenticacaoUsuario(@RequestBody @Valid LoginDTO loginDTO) {
        RecoveryJwtTokenDto token = usuarioService.autenticadorUsuario(loginDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody @Valid CriarUsuarioDTO usuario) {
        usuarioService.inserir(usuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> getAuthenticationTest() {
        return new ResponseEntity<>("Autenticado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/test/customer")
    public ResponseEntity<String> getCustomerAuthenticationTest() {
        return new ResponseEntity<>("Cliente autenticado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/test/administrator")
    public ResponseEntity<String> getAdminAuthenticationTest() {
        return new ResponseEntity<>("Administrador autenticado com sucesso", HttpStatus.OK);
    }

}
