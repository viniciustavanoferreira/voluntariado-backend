package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoVoluntarioRequestDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;

public class ServicoVoluntarioRequestDTOMapper {

    public static Servico toServicoEntity(Servico servico, Voluntario voluntario, ServicoVoluntarioRequestDTO servicoVoluntarioRequestDTO) {
        servico.setTipoServico(servicoVoluntarioRequestDTO.getTipoServico());
        servico.setOrdem(servicoVoluntarioRequestDTO.getOrdem());
        servico.setDataInicio(servicoVoluntarioRequestDTO.getDataInicio());
        servico.setDataFim(servicoVoluntarioRequestDTO.getDataFim());
        servico.setDestino(servicoVoluntarioRequestDTO.getDestino());
        servico.setStatus(servicoVoluntarioRequestDTO.getStatus());
        servico.setVoluntarioServico(voluntario);
        return servico;
    }

}
