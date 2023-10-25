package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CriarServicoException;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.ServicoRequestDTOMapper;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.ServicoResponseDTOMapper;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

public class CriarServicoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(AlterarIdosoUseCase.class);
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final CriarOuAlterarServicoUseCase criarOuAlterarServicoUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarIdosoUseCase buscarIdosoUseCase;

    public CriarServicoUseCase(BuscarServicoUseCase buscarServicoUseCase,
                               CriarOuAlterarServicoUseCase criarOuAlterarServicoUseCase,
                               BuscarUsuarioUseCase buscarUsuarioUseCase,
                               BuscarIdosoUseCase buscarIdosoUseCase) {
        this.buscarServicoUseCase = buscarServicoUseCase;
        this.criarOuAlterarServicoUseCase = criarOuAlterarServicoUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarIdosoUseCase = buscarIdosoUseCase;
    }

    public ServicoResponseDTO execute(final ServicoRequestDTO servicoRequestDTO) {
        LOG.info("Inicio - Criar servico");

        final var usuario = buscarUsuarioUseCase.executeByUser(servicoRequestDTO.getIdUsuarioIdoso());
        if (usuario == null || usuario.getIdUsuario().isBlank())
            throw new CriarServicoException("Nao existe uma pessoa cadastrada com esse usuario");

        Idoso idoso = null;
        if (usuario.getPerfil().equals("IDOSO"))
            idoso = buscarIdosoUseCase.executeByUser(servicoRequestDTO.getIdUsuarioIdoso());

        if (idoso == null)
            throw new CriarServicoException("Nao existe um perfil idoso cadastrado para este usuario");

        LOG.info("Fim - Criar servico");

        return ServicoResponseDTOMapper
                .fromEntity(criarOuAlterarServicoUseCase
                        .execute(ServicoRequestDTOMapper
                            .toServicoEntity(idoso, servicoRequestDTO)));
    }

}
