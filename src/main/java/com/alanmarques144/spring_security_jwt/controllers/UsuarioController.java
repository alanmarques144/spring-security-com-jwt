package com.alanmarques144.spring_security_jwt.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanmarques144.spring_security_jwt.dto.UsuarioDto;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto){
        return usuarioDto;
        
    }
}
