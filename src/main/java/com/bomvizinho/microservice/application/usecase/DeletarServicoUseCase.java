package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.DeletarServicoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeletarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(DeletarServicoUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final ManterServicoUseCase manterServicoUseCase;

    public DeletarServicoUseCase(BuscarServicoUseCase buscarServicoUseCase,
                                 ManterServicoUseCase manterServicoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
        this.manterServicoUseCase = manterServicoUseCase;
    }

    public void execute(final Long codigoServico) {
        LOG.info("Inicio - Deletar servico");

        final var servicos = buscarServicoUseCase.executeById(codigoServico);
        if (servicos == null || servicos.isEmpty())
            throw new DeletarServicoException("Nao existe servico cadastrado para o codigo informado");

        manterServicoUseCase.executeDelete(servicos.get(0).getId());

        LOG.info("Inicio - Deletar servico");
    }

}
