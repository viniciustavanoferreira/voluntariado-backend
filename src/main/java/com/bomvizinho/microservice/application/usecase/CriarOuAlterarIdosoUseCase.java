package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarOuAlterarIdosoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.IdosoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class CriarOuAlterarIdosoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CriarOuAlterarIdosoUseCase.class);
    private final IdosoRepository idosoRepository;
    private final RetryTemplate retryTemplate;

    public CriarOuAlterarIdosoUseCase(IdosoRepository idosoRepository, RetryTemplate retryTemplate) {
        this.idosoRepository = idosoRepository;
        this.retryTemplate = retryTemplate;
    }

    public void execute(final Idoso idoso) {
        final var failedToExecute = retryTemplate
                     .execute(context -> criarOuAlterarIdoso(idoso),
                              context -> failedToExecute());

        if (failedToExecute)
            throw new CriarOuAlterarIdosoException("Falha ao tentar criar ou alterar idoso");
    }

    private boolean criarOuAlterarIdoso(final Idoso idoso) {
        LOG.info("Inicio - Criar ou alterar idoso");

        idosoRepository.save(idoso);

        LOG.info("Fim - Criar ou alterar idoso - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel criar ou alterar o idoso no banco de dados");

        return true;
    }

}
