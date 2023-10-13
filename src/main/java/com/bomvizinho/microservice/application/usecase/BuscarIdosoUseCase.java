package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarIdosoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.IdosoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuscarIdosoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarIdosoUseCase.class);
    private final IdosoRepository idosoRepository;
    private final RetryTemplate retryTemplate;

    public BuscarIdosoUseCase(IdosoRepository idosoRepository,
                              RetryTemplate retryTemplate) {
        this.idosoRepository = idosoRepository;
        this.retryTemplate = retryTemplate;
    }

    public Idoso executeByUser(final String idUsuario) {
        return retryTemplate
                .execute(context -> buscarIdosoPorUsuario(idUsuario),
                         context -> failedToExecute());
    }

    private Idoso buscarIdosoPorUsuario(final String idUsuario) {
        LOG.info("Inicio - Busca de idoso por usuario");

        final var idoso = idosoRepository.findByUsuarioIdoso_IdUsuario(idUsuario);
        if (idoso == null){
            LOG.info("Fim - Busca de idoso por usuario - Nao existe idoso com o usuario informado");
        }

        LOG.info("Fim - Busca de idoso por usuario");

        return idoso;
    }

    public Idoso executeById(final Long id) {
        return retryTemplate
                .execute(context -> buscarIdosoPorCodigo(id),
                        context -> failedToExecute());
    }

    private Idoso buscarIdosoPorCodigo(final Long id) {
        LOG.info("Inicio - Busca de idoso por codigo");

        final var idoso = idosoRepository.findById(id);
        if (idoso.isEmpty()){
            LOG.info("Fim - Busca de idoso por usuario - Nao existe idoso com o codigo informado");
            return null;
        }

        LOG.info("Fim - Busca de idoso por codigo");

        return idoso.get();
    }

    private Idoso failedToExecute() {
        throw new BuscarIdosoException("Tentativas esgotadas - Nao foi possivel buscar o idoso no banco de dados");
    }

}
