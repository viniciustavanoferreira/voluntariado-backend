package com.bomvizinho.microservice.boundary.controller.dto.response.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoResponseDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;

import java.util.List;
import java.util.stream.Collectors;

public class ServicoResponseDTOMapper {

    public static List<ServicoResponseDTO> fromEntities(List<Servico> servicoList) {
        return servicoList.stream()
                .map(servico ->
                    ServicoResponseDTO.Builder
                        .aServicoResponseDTO()
                                .withId(servico.getId())
                                .withOrdem(servico.getOrdem())
                                .withTipoServico(servico.getTipoServico())
                                .withStatus(servico.getStatus())
                                .withDestino(servico.getDestino())
                                .withDataHoraInicio(servico.getDataInicio())
                                .withDataHoraFim(servico.getDataFim())
                        .build()
                ).collect(Collectors.toList());
    }

    public static ServicoResponseDTO fromEntity(Servico servico) {
        return ServicoResponseDTO.Builder
                    .aServicoResponseDTO()
                        .withId(servico.getId())
                        .withOrdem(servico.getOrdem())
                        .withTipoServico(servico.getTipoServico())
                        .withStatus(servico.getStatus())
                        .withDestino(servico.getDestino())
                        .withDataHoraInicio(servico.getDataInicio())
                        .withDataHoraFim(servico.getDataFim())
                    .build();
    }

}
