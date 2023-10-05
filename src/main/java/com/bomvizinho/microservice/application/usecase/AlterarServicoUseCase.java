package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.AlterarServicoException;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoVoluntarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.ServicoVoluntarioRequestDTOMapper;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AlterarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(AlterarServicoUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;
    private final CriarOuAlterarServicoUseCase criarOuAlterarServicoUseCase;

    public AlterarServicoUseCase(BuscarServicoUseCase buscarServicoUseCase,
                                 BuscarVoluntarioUseCase buscarVoluntarioUseCase,
                                 CriarOuAlterarServicoUseCase criarOuAlterarServicoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
        this.criarOuAlterarServicoUseCase = criarOuAlterarServicoUseCase;
    }

    public void execute(ServicoVoluntarioRequestDTO servicoVoluntarioRequestDTO) {
        LOG.info("Inicio - Alterar servico");

        final var servicos = buscarServicoUseCase.executeById(servicoVoluntarioRequestDTO.getCodigoServico());
        if (servicos == null || servicos.isEmpty())
            throw new AlterarServicoException("Nao existe servico cadastrado para o codigo informado");

        Voluntario voluntario = null;
        if (servicoVoluntarioRequestDTO.getIdUsuarioVoluntario() != null) {
            voluntario = buscarVoluntarioUseCase.execute(servicoVoluntarioRequestDTO.getIdUsuarioVoluntario());
            if (voluntario == null)
                throw new AlterarServicoException("Nao existe um perfil voluntario cadastrado para este usuario");
        }

        criarOuAlterarServicoUseCase
                .execute(ServicoVoluntarioRequestDTOMapper
                        .toServicoEntity(servicos.get(0), voluntario, servicoVoluntarioRequestDTO));

        LOG.info("Inicio - Alterar servico");
    }

}
