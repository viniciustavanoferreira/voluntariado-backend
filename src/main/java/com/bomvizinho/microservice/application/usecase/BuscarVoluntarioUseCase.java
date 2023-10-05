package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarVoluntarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.VoluntarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class BuscarVoluntarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarVoluntarioUseCase.class);
    private final VoluntarioRepository voluntarioRepository;
    private final RetryTemplate retryTemplate;

    public BuscarVoluntarioUseCase(VoluntarioRepository voluntarioRepository,
                                   RetryTemplate retryTemplate) {
        this.voluntarioRepository = voluntarioRepository;
        this.retryTemplate = retryTemplate;
    }

    public Voluntario execute(final String idUsuario) {
        return retryTemplate
                .execute(context -> buscarVoluntario(idUsuario),
                         context -> failedToExecute());
    }

    private Voluntario buscarVoluntario(final String idUsuario) {
        LOG.info("Inicio - Busca de voluntario por usuario");

        final var voluntario = voluntarioRepository.findByUsuarioVoluntario_IdUsuario(idUsuario);
        if (voluntario == null){
            LOG.info("Fim - Busca de voluntario por usuario - Nao existe voluntario com o usuario informado");
        }

        LOG.info("Fim - Busca de voluntario por usuario");

        return voluntario;
    }

    private Voluntario failedToExecute() {
        throw new BuscarVoluntarioException("Tentativas esgotadas - Nao foi possivel buscar o voluntario no banco de dados");
    }

}
