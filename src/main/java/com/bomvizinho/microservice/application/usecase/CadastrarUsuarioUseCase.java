package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CadastrarUsuarioException;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.UsuarioRequestDTOMapper;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CadastrarUsuarioUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase;
    private final CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase;
    private final CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase;

    public CadastrarUsuarioUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                                   CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase,
                                   CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase,
                                   CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criarOuAlterarUsuarioUseCase = criarOuAlterarUsuarioUseCase;
        this.criarOuAlterarVoluntarioUseCase = criarOuAlterarVoluntarioUseCase;
        this.criarOuAlterarIdosoUseCase = criarOuAlterarIdosoUseCase;
    }

    public void execute(final UsuarioRequestDTO usuarioRequestDTO) {
        LOG.info("Inicio - Cadastrar usuario");

        var usuario = buscarUsuarioUseCase.executeByUser(usuarioRequestDTO.getUsuario());
        if (usuario != null && !usuario.getIdUsuario().isBlank())
            throw new CadastrarUsuarioException("Ja existe uma pessoa cadastrada com este usuario");

        usuario = criarOuAlterarUsuarioUseCase.execute(UsuarioRequestDTOMapper.toUsuarioEntity(usuarioRequestDTO));

        switch (usuarioRequestDTO.getPerfil()){
            case "VOLUNTARIO":
                criarOuAlterarVoluntarioUseCase
                        .execute(Voluntario.Builder
                                .aVoluntario()
                                .withUsuarioVoluntario(usuario)
                                .build());
                break;
            case "IDOSO":
                criarOuAlterarIdosoUseCase
                        .execute(Idoso.Builder
                                .anIdoso()
                                .withUsuarioIdoso(usuario)
                                .build());
                break;
            default:
                throw new CadastrarUsuarioException("Perfil nao aceito pelo sistema");
        }

        LOG.info("Fim - Cadastrar usuario");
    }

}
