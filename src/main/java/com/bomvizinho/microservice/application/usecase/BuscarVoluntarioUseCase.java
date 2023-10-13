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

    public Voluntario executeByUser(final String idUsuario) {
        return retryTemplate
                .execute(context -> buscarVoluntarioPorUsuario(idUsuario),
                         context -> failedToExecute());
    }

    private Voluntario buscarVoluntarioPorUsuario(final String idUsuario) {
        LOG.info("Inicio - Busca de voluntario por usuario");

        final var voluntario = voluntarioRepository.findByUsuarioVoluntario_IdUsuario(idUsuario);
        if (voluntario == null){
            LOG.info("Fim - Busca de voluntario por usuario - Nao existe voluntario com o usuario informado");
        }

        LOG.info("Fim - Busca de voluntario por usuario");

        return voluntario;
    }

    public Voluntario executeById(final Long id) {
        return retryTemplate
                .execute(context -> buscarVoluntarioPorCodigo(id),
                        context -> failedToExecute());
    }

    private Voluntario buscarVoluntarioPorCodigo(final Long id) {
        LOG.info("Inicio - Busca de voluntario por codigo");

        final var voluntario = voluntarioRepository.findById(id);
        if (voluntario.isEmpty()){
            LOG.info("Fim - Busca de voluntario por codigo - Nao existe voluntario com o codigo informado");
            return null;
        }

        LOG.info("Fim - Busca de voluntario por codigo");

        return voluntario.get();
    }

    private Voluntario failedToExecute() {
        throw new BuscarVoluntarioException("Tentativas esgotadas - Nao foi possivel buscar o voluntario no banco de dados");
    }

}
