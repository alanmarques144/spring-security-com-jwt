package com.alanmarques144.spring_security_jwt.dto;

import com.alanmarques144.spring_security_jwt.enums.RoleEnum;

public record UsuarioDto(
    String nome,
    String login,
    String senha,
    RoleEnum role
) {
    
}
