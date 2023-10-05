package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarOuAlterarUsuarioException;
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

    public Usuario execute(final Usuario usuario) {
        return retryTemplate
                     .execute(context -> criarOuAlterarUsuario(usuario),
                              context -> failedToExecute());
    }

    private Usuario criarOuAlterarUsuario(final Usuario usuario) {
        LOG.info("Inicio - Criar ou alterar usuario");

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        LOG.info("Fim - Criar ou alterar usuario - Sucesso nesta operacao com o banco de dados");

        return usuarioSalvo;
    }

    private Usuario failedToExecute() {
        throw new CriarOuAlterarUsuarioException("Tentativas esgotadas - Nao foi possivel criar ou alterar o usuario no banco de dados");
    }

}
