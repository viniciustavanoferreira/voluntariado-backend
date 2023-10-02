package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarUsuarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuscarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarUsuarioUseCase.class);
    private final UsuarioRepository usuarioRepository;
    private final RetryTemplate retryTemplate;

    public BuscarUsuarioUseCase(UsuarioRepository usuarioRepository,
                                RetryTemplate retryTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.retryTemplate = retryTemplate;
    }

    public Usuario execute(final String email) {
        return retryTemplate
                    .execute(context -> buscarUsuario(email),
                             context -> failedToExecute());
    }

    private Usuario buscarUsuario(final String email) {
        LOG.info("Inicio - Busca de usuario por email");

        final var usuario = usuarioRepository.getUsuarioByEmail(email);
        if(usuario.isEmpty()){
            LOG.info("Fim - Busca de usuario por email - Nao existe usuario com o email informado");
            return null;
        }

        LOG.info("Fim - Busca de usuario por email");

        return usuario.get(0);
    }

    private Usuario failedToExecute() {
        throw new BuscarUsuarioException("Tentativas esgotadas - Nao foi possivel buscar o usuario no banco de dados");
    }

}
