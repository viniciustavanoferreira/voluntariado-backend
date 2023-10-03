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
                                .withDataNascimento(usuario.getDataNascimento())
                                .withTelefone(usuario.getTelefone())
                                .withDisponibilidade(usuario.getDisponibilidade())
                                .withTipoPerfil(usuario.getTipoPerfil())
                                .withEndereco(usuario.getEndereco())
                                .withBloco(usuario.getBloco())
                                .withNumeroApartamento(usuario.getNumeroAp())
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
                    .withServicoResponseDTOList(servicoList
                            .stream()
                            .map(servico ->
                                    ServicoResponseDTO.Builder
                                            .aServicoResponseDTO()
                                                .withId(servico.getId())
                                                .withDataHoraFim(servico.getDataFim())
                                                .withDataHoraInicio(servico.getDataInicio())
                                                .withDestino(servico.getDestino())
                                                .withStatus(servico.getStatus())
                                                .withTipoServico(servico.getTipoServico())
                                            .build()
                            ).collect(Collectors.toList()))
                .build();
    }
    
}
