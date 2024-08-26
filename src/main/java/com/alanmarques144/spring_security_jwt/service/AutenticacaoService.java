package com.alanmarques144.spring_security_jwt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.alanmarques144.spring_security_jwt.dto.AuthDto;

public interface AutenticacaoService extends UserDetailsService {
    
    public String obterToken(AuthDto authDto);
}
