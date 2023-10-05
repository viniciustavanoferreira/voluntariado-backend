package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.ManterServicoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.ServicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class ManterServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(ManterServicoUseCase.class);
    private final ServicoRepository servicoRepository;
    private final RetryTemplate retryTemplate;

    public ManterServicoUseCase(ServicoRepository servicoRepository,
                                RetryTemplate retryTemplate) {
        this.servicoRepository = servicoRepository;
        this.retryTemplate = retryTemplate;
    }

    public void executeDelete(final Long codigoServico) {
        final var failedToExecute = retryTemplate
                                        .execute(context -> deletarServico(codigoServico),
                                                 context -> failedToExecute());

        if (failedToExecute)
            throw new ManterServicoException("Nao foi possivel deletar servico");
    }

    private boolean deletarServico(final Long codigoServico) {
        LOG.info("Inicio - Deletar servico");

        servicoRepository.deleteById(codigoServico);

        LOG.info("Fim - Deletar servico - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel operar com este servico no banco de dados");

        return true;
    }
}
