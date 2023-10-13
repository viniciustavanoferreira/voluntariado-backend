package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.DeletarServicoException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DeletarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(DeletarServicoUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final ManterServicoUseCase manterServicoUseCase;
    private final CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase;
    private final CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase;
    private final BuscarIdosoUseCase buscarIdosoUseCase;
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;

    public DeletarServicoUseCase(BuscarServicoUseCase buscarServicoUseCase,
                                 ManterServicoUseCase manterServicoUseCase,
                                 CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase,
                                 CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase,
                                 BuscarIdosoUseCase buscarIdosoUseCase,
                                 BuscarVoluntarioUseCase buscarVoluntarioUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
        this.manterServicoUseCase = manterServicoUseCase;
        this.criarOuAlterarIdosoUseCase = criarOuAlterarIdosoUseCase;
        this.criarOuAlterarVoluntarioUseCase = criarOuAlterarVoluntarioUseCase;
        this.buscarIdosoUseCase = buscarIdosoUseCase;
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
    }

    public void execute(final Long codigoServico) {
        LOG.info("Inicio - Deletar servico");

        final var servicos = buscarServicoUseCase.executeById(codigoServico);
        if (servicos == null || servicos.isEmpty())
            throw new DeletarServicoException("Nao existe servico cadastrado para o codigo informado");

        final var servico = servicos.get(0);
        Idoso idoso = null;
        Voluntario voluntario = null;

        if (servico.getIdosoServico() != null) {
            idoso = buscarIdosoUseCase.executeById(servico.getIdosoServico().getId());
            idoso.setServicoIdoso(null);
            criarOuAlterarIdosoUseCase.execute(idoso);
        }

        if (servico.getVoluntarioServico() != null) {
            voluntario = buscarVoluntarioUseCase.executeById(servico.getVoluntarioServico().getId());
            voluntario.setServicoVoluntario(null);
            criarOuAlterarVoluntarioUseCase.execute(voluntario);
        }

        if (idoso == null && voluntario == null)
            throw new DeletarServicoException("Nao existe servico associado com um perfil para o codigo informado");

        manterServicoUseCase.executeDelete(servicos.get(0).getId());

        LOG.info("Inicio - Deletar servico");
    }

}
