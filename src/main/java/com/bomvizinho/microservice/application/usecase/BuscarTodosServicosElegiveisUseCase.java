package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarServicoException;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.ServicoResponseDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosServicosElegiveisUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarTodosServicosElegiveisUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;


    public BuscarTodosServicosElegiveisUseCase(BuscarServicoUseCase buscarServicoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    public List<ServicoResponseDTO> execute() {
        LOG.info("Inicio - Buscar todos os servicos elegiveis para voluntarios");

        final var servicos = buscarServicoUseCase.executeByAllEligibles();
        if (servicos == null)
            throw new BuscarServicoException("Nao existem servicos elegiveis para voluntarios cadastrados no sistema");

        LOG.info("Fim - Buscar todos os servicos elegiveis para voluntarios");

        return ServicoResponseDTOMapper.fromEntities(servicos);
    }

}
