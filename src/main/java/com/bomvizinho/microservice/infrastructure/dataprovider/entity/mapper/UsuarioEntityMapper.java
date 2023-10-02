package com.bomvizinho.microservice.infrastructure.dataprovider.entity.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;

public class UsuarioEntityMapper {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.Builder
                .anUsuarioDTO()
                    .withNome(usuario.getNome())
                    .withEmail(usuario.getEmail())
                    .withSenha(usuario.getSenha())
                    .withPerfil(usuario.getTipoPerfil())
                    .withDataNascimento(String.valueOf(usuario.getDataNascimento()))
                    .withTelefone(usuario.getTelefone())
                    .withEndereco(usuario.getEndereco())
                .build();
    }

}
