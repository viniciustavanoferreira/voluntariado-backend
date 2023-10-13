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
                                            .withPerfil(usuario.getSenha())
                                            .withDisponibilidade(usuario.getSenha())
                                            .withComplemento(usuario.getSenha())
                                            .withEstado(usuario.getEstado())
                                            .withCidade(usuario.getCidade())
                                            .withBloco(usuario.getSenha())
                                            .withCep(usuario.getCep())
                                            .withBairro(usuario.getSenha())
                                            .withEndereco(usuario.getEndereco())
                                            .withNumeroAp(usuario.getSenha())
                                            .withEmail(usuario.getSenha())
                                            .withNome(usuario.getNome())
                                            .withTelefone(usuario.getTelefone())
                                            .withDataNascimento(usuario.getDataNascimento())
                                        .build()
                        ).collect(Collectors.toList());
    }

}
