package com.alanmarques144.spring_security_jwt.dto;

public record UsuarioDto(
    String nome,
    String login,
    String senha
) {
    
}
