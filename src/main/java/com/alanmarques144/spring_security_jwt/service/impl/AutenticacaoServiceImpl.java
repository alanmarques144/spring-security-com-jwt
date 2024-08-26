package com.alanmarques144.spring_security_jwt.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.alanmarques144.spring_security_jwt.dto.AuthDto;
import com.alanmarques144.spring_security_jwt.models.Usuario;
import com.alanmarques144.spring_security_jwt.repository.UsuarioRepository;
import com.alanmarques144.spring_security_jwt.service.AutenticacaoService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public String obterToken(AuthDto authDto) {
        Usuario usuario = usuarioRepository.findByLogin(authDto.login());
        return gerarTokenJwt(usuario);
    }

    public String gerarTokenJwt(Usuario usuario){

        try {
            
            Algorithm algorithm =  Algorithm.HMAC256("my-secret");

            return JWT.create().withIssuer("auth-api")
                               .withSubject(usuario.getLogin())
                               .withExpiresAt(gerarDataExpiracao())
                               .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao tentar gerar o token! " + e.getMessage());
        }
    }

    private Instant gerarDataExpiracao() {
       return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
    
}
