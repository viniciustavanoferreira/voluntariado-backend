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
                    .withServicoResponseDTOList(servicoList == null ? null :
                            servicoList.stream()
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
