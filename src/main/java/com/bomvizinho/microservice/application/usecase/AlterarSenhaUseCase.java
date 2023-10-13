package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.AlterarSenhaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AlterarSenhaUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(AlterarSenhaUseCase.class);

    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase;

    public AlterarSenhaUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                               CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criarOuAlterarUsuarioUseCase = criarOuAlterarUsuarioUseCase;
    }

    public void execute(final String idUsuario, final String novaSenha) {
        LOG.info("Inicio - Alterar senha");

        final var usuario = buscarUsuarioUseCase.executeByUser(idUsuario);
        if (usuario == null || usuario.getIdUsuario().isBlank())
            throw new AlterarSenhaException("Nao existe uma pessoa cadastrada com este usuario");

        usuario.setSenha(novaSenha);

        criarOuAlterarUsuarioUseCase.execute(usuario);

        LOG.info("Fim - Alterar senha");
    }

}
