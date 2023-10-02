package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;

import java.sql.Date;

public class UsuarioDTOMapper {

    public static Usuario toUsuarioEntity(UsuarioDTO usuarioDTO) {
        return Usuario.Builder
                .anUsuario()
                    .withNome(usuarioDTO.getNome())
                    .withEmail(usuarioDTO.getEmail())
                    .withSenha(usuarioDTO.getSenha())
                    .withDataNascimento(Date.valueOf(usuarioDTO.getDataNascimento()))
                    .withTipoPerfil(usuarioDTO.getPerfil())
                    .withTelefone(usuarioDTO.getTelefone())
                    .withEndereco(usuarioDTO.getEndereco())
                .build();
    }

}
