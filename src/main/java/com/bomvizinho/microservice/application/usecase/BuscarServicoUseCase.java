package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.BuscarServicoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.repository.ServicoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuscarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(BuscarServicoUseCase.class);
    private final ServicoRepository servicoRepository;
    private final RetryTemplate retryTemplate;

    public BuscarServicoUseCase(ServicoRepository servicoRepository,
                                RetryTemplate retryTemplate) {
        this.servicoRepository = servicoRepository;
        this.retryTemplate = retryTemplate;
    }

    public List<Servico> executeByVoluntario(final Long idVoluntario){
        return retryTemplate
                .execute(context -> buscarServicoVoluntario(idVoluntario),
                         context -> failedToExecute());
    }

    private List<Servico> buscarServicoVoluntario(Long idVoluntario) {
        LOG.info("Inicio - Busca de servico por voluntario");

        final var servico = servicoRepository.findByVoluntarioServicoId(idVoluntario);
        if (servico.isEmpty()){
            LOG.info("Fim - Busca de servico por voluntario - Nao existem servicos para o voluntario informado");
            return null;
        }

        LOG.info("Fim - Busca de servico por voluntario");

        return servico;
    }

    public List<Servico> executeByIdoso(final Long idIdoso){
        return retryTemplate
                .execute(context -> buscarServicoIdoso(idIdoso),
                         context -> failedToExecute());
    }

    private List<Servico> buscarServicoIdoso(Long idIdoso) {
        LOG.info("Inicio - Busca de servico por idoso");

        final var servico = servicoRepository.findByIdosoServicoId(idIdoso);
        if (servico.isEmpty()){
            LOG.info("Fim - Busca de servico por idoso - Nao existem servicos para o idoso informado");
            return null;
        }

        LOG.info("Fim - Busca de servico por idoso");

        return servico;
    }

    private List<Servico> failedToExecute() {
        throw new BuscarServicoException("Tentativas esgotadas - Nao foi possivel buscar os servicos no banco de dados");
    }

}
