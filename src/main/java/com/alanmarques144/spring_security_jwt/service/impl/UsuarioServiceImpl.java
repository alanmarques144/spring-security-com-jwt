package com.alanmarques144.spring_security_jwt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.alanmarques144.spring_security_jwt.dto.UsuarioDto;
import com.alanmarques144.spring_security_jwt.models.Usuario;
import com.alanmarques144.spring_security_jwt.repository.UsuarioRepository;
import com.alanmarques144.spring_security_jwt.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UsuarioDto salvar(UsuarioDto usuarioDto) {
        
        Usuario usuarioJaExiste = usuarioRepository.findByLogin(usuarioDto.login());

        if (usuarioJaExiste != null) {
            throw new RuntimeException("Usuario ja existe!");
        }

        String passwordHash = passwordEncoder.encode(usuarioDto.senha());

        Usuario entity = new Usuario(usuarioDto.nome(), usuarioDto.login(), passwordHash);
        Usuario novoUsuario = usuarioRepository.save(entity);
        return new UsuarioDto(novoUsuario.getNome(), novoUsuario.getLogin(),novoUsuario.getSenha());
    }
    
}
