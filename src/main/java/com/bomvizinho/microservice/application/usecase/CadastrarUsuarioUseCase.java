package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.CadastrarUsuarioException;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.mapper.UsuarioDTOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CadastrarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(CadastrarUsuarioUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase;

    public CadastrarUsuarioUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                                   CriarOuAlterarUsuarioUseCase criarOuAlterarUsuarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.criarOuAlterarUsuarioUseCase = criarOuAlterarUsuarioUseCase;
    }

    public void execute(final UsuarioDTO usuarioDTO) {
        LOG.info("Inicio - Cadastrar usuario");

        final var usuario = buscarUsuarioUseCase.execute(usuarioDTO.getEmail());
        if (usuario != null && !usuario.getEmail().isBlank())
            throw new CadastrarUsuarioException("Ja existe um usuario cadastrado com este email");

        if (!usuarioDTO.getPerfil().equals("VOLUNTARIO") && !usuarioDTO.getPerfil().equals("IDOSO"))
            throw new CadastrarUsuarioException("Perfil nao aceito pelo sistema");

        criarOuAlterarUsuarioUseCase.execute(UsuarioDTOMapper.toUsuarioEntity(usuarioDTO));

        LOG.info("Fim - Cadastrar usuario");
    }

}
