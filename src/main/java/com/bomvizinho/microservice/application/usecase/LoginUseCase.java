package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.LoginException;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.mapper.UsuarioEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(LoginUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public LoginUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    public UsuarioDTO execute(final String email, final String password) {
        LOG.info("Inicio - Login");

        final var usuario = buscarUsuarioUseCase.execute(email);
        if (usuario == null || usuario.getEmail().isBlank())
            throw new LoginException("Nao existe um usuario cadastrado com este email");

        final var usuarioDTO = UsuarioEntityMapper.toUsuarioDTO(usuario);
        if (usuarioDTO.getSenha().isBlank() || !usuarioDTO.getSenha().equals(password))
            throw new LoginException("Nao existe um usuario cadastrado com estas credenciais");
        else
            usuarioDTO.setSenha(null);

//        if (usuarioDTO.getPerfil().equals("VOLUNTARIO"))
//            //BuscarServicoVoluntarioUseCase
//        else
//            //BuscarServicoIdosoUseCase

        LOG.info("Fim - Login");

        return usuarioDTO;
    }

}
