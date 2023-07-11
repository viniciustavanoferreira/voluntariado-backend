package com.bomvizinho.microservice.service;

import com.bomvizinho.microservice.entity.Usuario;
import com.bomvizinho.microservice.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void adicionaUsuario(String email, String password){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(password);
        usuarioRepository.save(usuario);
    }

}
