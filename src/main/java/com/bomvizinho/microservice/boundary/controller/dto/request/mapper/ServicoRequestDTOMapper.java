package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoRequestDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;

public class ServicoRequestDTOMapper {

    public static Servico toServicoEntity(Idoso idoso, ServicoRequestDTO servicoRequestDTO) {
        return Servico.Builder
                .aServico()
                    .withTipoServico(servicoRequestDTO.getTipoServico())
                    .withDataInicio(servicoRequestDTO.getDataInicio())
                    .withDataFim(servicoRequestDTO.getDataFim())
                    .withDestino(servicoRequestDTO.getDestino())
                    .withOrdem(servicoRequestDTO.getOrdem())
                    .withStatus(servicoRequestDTO.getStatus())
                    .withIdosoServico(idoso)
                .build();
    }

}
