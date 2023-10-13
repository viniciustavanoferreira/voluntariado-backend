package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarServicoException;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.ServicoResponseDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosServicosUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarTodosServicosUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;


    public BuscarTodosServicosUseCase(BuscarServicoUseCase buscarServicoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    public List<ServicoResponseDTO> execute() {
        LOG.info("Inicio - Buscar todos os servicos");

        final var servicos = buscarServicoUseCase.executeByAll();
        if (servicos == null)
            throw new BuscarServicoException("Nao existem servicos cadastrados no sistema");

        LOG.info("Fim - Buscar todos os servicos");

        return ServicoResponseDTOMapper.fromEntities(servicos);
    }

}
