package com.alanmarques144.spring_security_jwt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alanmarques144.spring_security_jwt.enums.RoleEnum;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_USUARIO")
public class Usuario implements UserDetails {
    
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private RoleEnum role;
    
    public Usuario(String nome, String login, String senha, RoleEnum role) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == RoleEnum.ADMIN){
            return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER")
            );
        }
        return List.of(
            new SimpleGrantedAuthority("ROLE_USER")
        );
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
    
    
}
