package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.ManterServicoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class ManterUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(ManterUsuarioUseCase.class);
    private final UsuarioRepository usuarioRepository;
    private final RetryTemplate retryTemplate;

    public ManterUsuarioUseCase(UsuarioRepository usuarioRepository,
                                RetryTemplate retryTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.retryTemplate = retryTemplate;
    }

    public void executeDelete(final Long codigoUsuario) {
        final var failedToExecute = retryTemplate
                                        .execute(context -> deletarUsuario(codigoUsuario),
                                                 context -> failedToExecute());

        if (failedToExecute)
            throw new ManterServicoException("Nao foi possivel deletar usuario");
    }

    private boolean deletarUsuario(final Long codigoUsuario) {
        LOG.info("Inicio - Deletar usuario");

        usuarioRepository.deleteById(codigoUsuario);

        LOG.info("Fim - Deletar usuario - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel operar com este usuario no banco de dados");

        return true;
    }

}
