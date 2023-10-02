package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarUsuarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class CriarOuAlterarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CriarOuAlterarUsuarioUseCase.class);
    private final UsuarioRepository usuarioRepository;
    private final RetryTemplate retryTemplate;

    public CriarOuAlterarUsuarioUseCase(UsuarioRepository usuarioRepository, RetryTemplate retryTemplate) {
        this.usuarioRepository = usuarioRepository;
        this.retryTemplate = retryTemplate;
    }

    public void execute(final Usuario usuario) {
        final var failedToExecute = retryTemplate
                     .execute(context -> criarOuAlterarUsuario(usuario),
                              context -> failedToExecute());

        if (failedToExecute)
            throw new CriarUsuarioException("Falha ao tentar criar ou alterar usuario");
    }

    private boolean criarOuAlterarUsuario(final Usuario usuario) {
        LOG.info("Inicio - Criar ou alterar usuario");

        usuarioRepository.save(usuario);

        LOG.info("Fim - Criar ou alterar usuario - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel criar ou alterar o usuario no banco de dados");

        return true;
    }

}
