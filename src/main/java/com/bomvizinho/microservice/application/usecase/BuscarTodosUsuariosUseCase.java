package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarUsuarioException;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.UsuarioResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.UsuarioResponseDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarTodosUsuariosUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarTodosUsuariosUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public BuscarTodosUsuariosUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public List<UsuarioResponseDTO> execute() {
        LOG.info("Inicio - Buscar todos os usuarios");

        final var usuarios = buscarUsuarioUseCase.executeByAll();
        if (usuarios == null)
            throw new BuscarUsuarioException("Nao existem pessoas com usuarios cadastrados no sistema");

        LOG.info("Fim - Buscar todos os usuarios");

        return UsuarioResponseDTOMapper.fromEntities(usuarios);
    }

}
