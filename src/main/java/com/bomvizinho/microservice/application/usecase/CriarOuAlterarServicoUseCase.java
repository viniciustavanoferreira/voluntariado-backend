package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarOuAlterarServicoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.ServicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class CriarOuAlterarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CriarOuAlterarServicoUseCase.class);
    private final ServicoRepository servicoRepository;
    private final RetryTemplate retryTemplate;

    public CriarOuAlterarServicoUseCase(ServicoRepository servicoRepository,
                                        RetryTemplate retryTemplate) {
        this.servicoRepository = servicoRepository;
        this.retryTemplate = retryTemplate;
    }

    public void execute(final Servico servico) {
        final var failedToExecute = retryTemplate
                    .execute(context -> criarOuAlterarServico(servico),
                             context -> failedToExecute());

        if (failedToExecute)
            throw new CriarOuAlterarServicoException("Falha ao tentar criar ou alterar servico");
    }

    private boolean criarOuAlterarServico(final Servico servico) {
        LOG.info("Inicio - Criar ou alterar servico");

        servicoRepository.save(servico);

        LOG.info("Fim - Criar ou alterar servico - Sucesso nesta operacao com o banco de dados");

        return false;
    }

    private boolean failedToExecute() {
        LOG.error("Tentativas esgotadas - Nao foi possivel criar ou alterar o servico no banco de dados");

        return true;
    }

}
