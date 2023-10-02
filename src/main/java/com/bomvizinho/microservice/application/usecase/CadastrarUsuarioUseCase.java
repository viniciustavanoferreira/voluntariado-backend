package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CadastrarUsuarioException;
import com.bomvizinho.microservice.boundary.controller.dto.login.UsuarioDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CadastrarUsuarioUseCase.class);

    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public CadastrarUsuarioUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public void execute(final UsuarioDTO usuarioDTO) {
        LOG.info("Inicio - Cadastrar usuario");

        final var usuario = buscarUsuarioUseCase.execute(usuarioDTO.getEmail());
        if(usuario != null && !usuario.getEmail().isBlank())
            throw new CadastrarUsuarioException("Ja existe um usuario cadastrado com este email");

        

        LOG.info("Fim - Cadastrar usuario");
    }

}
