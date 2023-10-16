package com.bomvizinho.microservice.boundary.controller.dto.response.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.response.login.UsuarioResponseDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioResponseDTOMapper {

    public static List<UsuarioResponseDTO> fromEntities(List<Usuario> usuarioList) {
        return  usuarioList.stream()
                        .map(usuario ->
                                UsuarioResponseDTO.Builder
                                        .anUsuarioResponseDTO()
                                            .withId(usuario.getId())
                                            .withUsuario(usuario.getIdUsuario())
                                            .withPerfil(usuario.getPerfil())
                                            .withDisponibilidade(usuario.getDisponibilidade())
                                            .withComplemento(usuario.getComplemento())
                                            .withEstado(usuario.getEstado())
                                            .withCidade(usuario.getCidade())
                                            .withBloco(usuario.getBloco())
                                            .withCep(usuario.getCep())
                                            .withBairro(usuario.getBairro())
                                            .withEndereco(usuario.getEndereco())
                                            .withNumeroAp(usuario.getNumeroAp())
                                            .withEmail(usuario.getEmail())
                                            .withNome(usuario.getNome())
                                            .withTelefone(usuario.getTelefone())
                                            .withDataNascimento(usuario.getDataNascimento())
                                        .build()
                        ).collect(Collectors.toList());
    }

}
