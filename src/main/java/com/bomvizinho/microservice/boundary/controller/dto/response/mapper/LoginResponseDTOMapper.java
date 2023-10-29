package com.bomvizinho.microservice.boundary.controller.dto.response.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.response.login.*;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;

import java.util.List;
import java.util.stream.Collectors;

public class LoginResponseDTOMapper {
    
    public static LoginResponseDTO fromEntities(Usuario usuario, Voluntario voluntario, Idoso idoso, List<Servico> servicoList) {
        return LoginResponseDTO.Builder
                .aLoginResponseDTO()
                    .withUsuarioResponseDTO(UsuarioResponseDTO.Builder
                            .anUsuarioResponseDTO()
                                .withId(usuario.getId())
                                .withNome(usuario.getNome())
                                .withEmail(usuario.getEmail())
                                .withEndereco(usuario.getEndereco())
                                .withBairro(usuario.getBairro())
                                .withCep(usuario.getCep())
                                .withNumeroAp(usuario.getNumeroAp())
                                .withBloco(usuario.getBloco())
                                .withCidade(usuario.getCidade())
                                .withEstado(usuario.getEstado())
                                .withComplemento(usuario.getComplemento())
                                .withPerfil(usuario.getPerfil())
                                .withUsuario(usuario.getIdUsuario())
                                .withDisponibilidade(usuario.getDisponibilidade())
                                .withSenha(usuario.getSenha())
                                .withDataNascimento(usuario.getDataNascimento())
                                .withTelefone(usuario.getTelefone())
                            .build())
                    .withVoluntarioResponseDTO(VoluntarioResponseDTO.Builder
                            .aVoluntarioResponseDTO()
                                .withId(voluntario == null ? null : voluntario.getId())
                                .withHabilidade(voluntario == null ? null : voluntario.getHabilidade())
                                .withPreferencia(voluntario == null ? null : voluntario.getPreferencia())
                            .build())
                    .withIdosoResponseDTO(IdosoResponseDTO.Builder
                            .anIdosoResponseDTO()
                                .withId(idoso == null ? null : idoso.getId())
                                .withAssistenciaRequerida(idoso == null ? null : idoso.getAssistenciaRequerida())
                                .withCondicaoSaude(idoso == null ? null : idoso.getCondicaoSaude())
                                .withPreferenciaDia(idoso == null ? null : idoso.getPreferenciaDia())
                            .build())
                    .withServicoAssociadoResponseDTOList(servicoList == null ? null :
                            servicoList.stream()
                                .map(servico ->
                                        ServicoAssociadoResponseDTO.Builder
                                                .aServicoAssociadoResponseDTO()
                                                    .withId(servico.getId())
                                                    .withTipoServico(servico.getTipoServico())
                                                    .withDataHoraFim(servico.getDataFim())
                                                    .withDataHoraInicio(servico.getDataInicio())
                                                    .withOrdem(servico.getOrdem())
                                                    .withDestino(servico.getDestino())
                                                    .withStatus(servico.getStatus())
                                                    .withIdUsuarioIdoso(servico.getIdosoServico() == null ?
                                                            null : servico.getIdosoServico().getUsuarioIdoso().getIdUsuario())
                                                    .withIdUsuarioVoluntario(servico.getVoluntarioServico() == null ?
                                                            null : servico.getVoluntarioServico().getUsuarioVoluntario().getIdUsuario())
                                                .build()
                                ).collect(Collectors.toList()))
                .build();
    }
    
}
