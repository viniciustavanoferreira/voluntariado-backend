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

    public Servico execute(final Servico servico) {
        return retryTemplate
                .execute(context -> criarOuAlterarServico(servico),
                         context -> failedToExecute());
    }

    private Servico criarOuAlterarServico(final Servico servico) {
        LOG.info("Inicio - Criar ou alterar servico");

        final var servicoBase = servicoRepository.save(servico);

        LOG.info("Fim - Criar ou alterar servico - Sucesso nesta operacao com o banco de dados");

        return servicoBase;
    }

    private Servico failedToExecute() {
        throw new CriarOuAlterarServicoException("Tentativas esgotadas - Nao foi possivel criar ou alterar o servico no banco de dados");
    }

}
