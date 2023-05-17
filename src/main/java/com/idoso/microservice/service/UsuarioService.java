package com.idoso.microservice.service;

import com.idoso.microservice.entity.Usuario;
import com.idoso.microservice.repository.UsuarioRepository;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void adicionaUsuario(String username, String password){
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(username);
        usuario.setSenha(password);
        usuarioRepository.save(usuario);
    }

}
