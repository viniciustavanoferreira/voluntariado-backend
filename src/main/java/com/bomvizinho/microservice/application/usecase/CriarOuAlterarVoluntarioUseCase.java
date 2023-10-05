package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarOuAlterarVoluntarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.VoluntarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class CriarOuAlterarVoluntarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CriarOuAlterarVoluntarioUseCase.class);
    private final VoluntarioRepository voluntarioRepository;
    private final RetryTemplate retryTemplate;

    public CriarOuAlterarVoluntarioUseCase(VoluntarioRepository voluntarioRepository, RetryTemplate retryTemplate) {
        this.voluntarioRepository = voluntarioRepository;
        this.retryTemplate = retryTemplate;
    }

    public void execute(final Voluntario voluntario) {
        final var failedToExecute = retryTemplate
                     .execute(context -> criarOuAlterarVoluntario(voluntario),
                              context -> failedToExecute());

        if (failedToExecute)
            throw new CriarOuAlterarVoluntarioException("Falha ao tentar criar ou alterar voluntario");
    }

    private boolean criarOuAlterarVoluntario(final Voluntario voluntario) {
        LOG.info("Inicio - Criar ou alterar voluntario");

        voluntarioRepository.save(voluntario);

        LOG.info("Fim - Criar ou alterar voluntario - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel criar ou alterar o voluntario no banco de dados");

        return true;
    }

}
