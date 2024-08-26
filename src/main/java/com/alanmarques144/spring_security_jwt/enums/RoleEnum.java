package com.alanmarques144.spring_security_jwt.enums;

import lombok.Getter;

@Getter
public enum RoleEnum {
    ADMIN ("admin"),
    USER ("user");

    private String role;

    private RoleEnum(String role) {
        this.role = role;
    }

    
}
