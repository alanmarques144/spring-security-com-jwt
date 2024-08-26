package com.alanmarques144.spring_security_jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alanmarques144.spring_security_jwt.dto.UsuarioDto;
import com.alanmarques144.spring_security_jwt.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/admin")
    private String getAdmin(){
        return "Permissao de administrador!";
    }

    @GetMapping("/user")
    private String getUser(){
        return "Permissao de usuario!";
    }

    @PostMapping
    private UsuarioDto salvar(@RequestBody UsuarioDto usuarioDto){
        
        return usuarioService.salvar(usuarioDto);
    }

}
