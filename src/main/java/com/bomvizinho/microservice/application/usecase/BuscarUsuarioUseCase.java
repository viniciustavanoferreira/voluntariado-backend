package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarUsuarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Usuario;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public Usuario executeByUser(final String idUsuario) {
        return retryTemplate
                    .execute(context -> buscarUsuario(idUsuario),
                             context -> failedToExecute());
    }

    private Usuario buscarUsuario(final String idUsuario) {
        LOG.info("Inicio - Busca de pessoa por usuario");

        final var usuario = usuarioRepository.findByIdUsuario(idUsuario);
        if (usuario.isEmpty()){
            LOG.info("Fim - Busca de pessoa por usuario - Nao existe pessoa com o usuario informado");
            return null;
        }

        LOG.info("Fim - Busca de pessoa por usuario");

        return usuario.get(0);
    }

    private Usuario failedToExecute() {
        throw new BuscarUsuarioException("Tentativas esgotadas - Nao foi possivel buscar a pessoa no banco de dados");
    }

    public List<Usuario> executeByAll() {
        return retryTemplate
                .execute(context -> buscarTodosUsuarios(),
                         context -> failedToExecuteByAll());
    }

    private List<Usuario> buscarTodosUsuarios() {
        LOG.info("Inicio - Busca de pessoas por todos os usuarios");

        final var usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()){
            LOG.info("Fim - Busca de pessoas por todos os usuarios - Nao existem pessoas cadastradas");
            return null;
        }

        LOG.info("Fim - Busca de pessoas por todos os usuarios");

        return usuarios;
    }

    private List<Usuario> failedToExecuteByAll() {
        throw new BuscarUsuarioException("Tentativas esgotadas - Nao foi possivel buscar as pessoas no banco de dados");
    }

}
