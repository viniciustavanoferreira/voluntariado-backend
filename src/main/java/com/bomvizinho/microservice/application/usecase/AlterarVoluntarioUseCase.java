package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.AlterarVoluntarioException;
import com.bomvizinho.microservice.boundary.controller.dto.request.VoluntarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.VoluntarioRequestDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AlterarVoluntarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(AlterarVoluntarioUseCase.class);
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;
    private final CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase;

    public AlterarVoluntarioUseCase(BuscarVoluntarioUseCase buscarVoluntarioUseCase,
                                    CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase) {
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
        this.criarOuAlterarVoluntarioUseCase = criarOuAlterarVoluntarioUseCase;
    }

    public void execute(final VoluntarioRequestDTO voluntarioRequestDTO) {
        LOG.info("Inicio - Alterar usuario");

        final var voluntario = buscarVoluntarioUseCase.executeByUser(voluntarioRequestDTO.getUsuarioRequestDTO().getUsuario());
        if (voluntario == null)
            throw new AlterarVoluntarioException("Nao existe um voluntario cadastrado com este usuario");

        if (!voluntarioRequestDTO.getUsuarioRequestDTO().getPerfil().equals("VOLUNTARIO"))
            throw new AlterarVoluntarioException("Perfil nao aceito pelo sistema para alterar dados de voluntario");

        criarOuAlterarVoluntarioUseCase
                .execute(VoluntarioRequestDTOMapper
                        .toVoluntarioEntity(voluntario, voluntarioRequestDTO));

        LOG.info("Fim - Alterar usuario");
    }

}
