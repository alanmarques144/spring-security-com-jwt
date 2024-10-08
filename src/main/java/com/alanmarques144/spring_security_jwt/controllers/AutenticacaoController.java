package com.alanmarques144.spring_security_jwt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alanmarques144.spring_security_jwt.dto.AuthDto;

import com.alanmarques144.spring_security_jwt.service.AutenticacaoService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AutenticacaoService autenticacaoService; 

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    private String auth(@RequestBody AuthDto authDto){
       var usuarioAutenticationToken = new UsernamePasswordAuthenticationToken(authDto.login(), authDto.senha());
       authenticationManager.authenticate(usuarioAutenticationToken);
       return autenticacaoService.obterToken(authDto);
    }
}
