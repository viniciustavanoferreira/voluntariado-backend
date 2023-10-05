package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioRequestDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;

public class UsuarioRequestDTOMapper {

    public static Usuario toUsuarioEntity(UsuarioRequestDTO usuarioRequestDTO) {
        return Usuario.Builder
                .anUsuario()
                    .withIdUsuario(usuarioRequestDTO.getUsuario())
                    .withEmail(usuarioRequestDTO.getEmail())
                    .withSenha(usuarioRequestDTO.getSenha())
                    .withNome(usuarioRequestDTO.getNome())
                    .withEndereco(usuarioRequestDTO.getEndereco())
                    .withBairro(usuarioRequestDTO.getBairro())
                    .withCidade(usuarioRequestDTO.getCidade())
                    .withEstado(usuarioRequestDTO.getEstado())
                    .withCep(usuarioRequestDTO.getCep())
                    .withNumeroAp(usuarioRequestDTO.getNumeroAp())
                    .withBloco(usuarioRequestDTO.getBloco())
                    .withComplemento(usuarioRequestDTO.getComplemento())
                    .withTelefone(usuarioRequestDTO.getTelefone())
                    .withDataNascimento(usuarioRequestDTO.getDataNascimento())
                    .withPerfil(usuarioRequestDTO.getPerfil())
                    .withDisponibilidade(usuarioRequestDTO.getDisponibilidade())
                .build();
    }

}
