package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.AlterarIdosoException;
import com.bomvizinho.microservice.application.exception.AlterarVoluntarioException;
import com.bomvizinho.microservice.boundary.controller.dto.request.IdosoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.IdosoRequestDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AlterarIdosoUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(AlterarIdosoUseCase.class);
    private final BuscarIdosoUseCase buscarIdosoUseCase;
    private final CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase;

    public AlterarIdosoUseCase(BuscarIdosoUseCase buscarIdosoUseCase,
                               CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase) {
        this.buscarIdosoUseCase = buscarIdosoUseCase;
        this.criarOuAlterarIdosoUseCase = criarOuAlterarIdosoUseCase;
    }

    public void execute(final IdosoRequestDTO idosoRequestDTO) {
        LOG.info("Inicio - Alterar idoso");

        final var idoso = buscarIdosoUseCase.executeByUser(idosoRequestDTO.getUsuarioRequestDTO().getUsuario());
        if (idoso == null)
            throw new AlterarIdosoException("Nao existe um idoso cadastrado com este usuario");

        if (!idosoRequestDTO.getUsuarioRequestDTO().getPerfil().equals("IDOSO"))
            throw new AlterarVoluntarioException("Perfil nao aceito pelo sistema para alterar dados de idoso");

        criarOuAlterarIdosoUseCase
                .execute(IdosoRequestDTOMapper
                        .toIdosoEntity(idoso, idosoRequestDTO));

        LOG.info("Fim - Alterar usuario");
    }

}
