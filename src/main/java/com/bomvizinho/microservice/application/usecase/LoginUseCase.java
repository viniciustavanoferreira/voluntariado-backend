package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.LoginException;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.LoginResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.LoginResponseDTOMapper;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(LoginUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;
    private final BuscarServicoUseCase buscarServicoUseCase;
    private final BuscarIdosoUseCase buscarIdosoUseCase;

    public LoginUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                        BuscarVoluntarioUseCase buscarVoluntarioUseCase,
                        BuscarIdosoUseCase buscarIdosoUseCase,
                        BuscarServicoUseCase buscarServicoUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
        this.buscarIdosoUseCase = buscarIdosoUseCase;
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    public LoginResponseDTO execute(final String idUsuario, final String senha) {
        LOG.info("Inicio - Login");

        final var usuario = buscarUsuarioUseCase.executeByUser(idUsuario);
        if (usuario == null || usuario.getIdUsuario().isBlank())
            throw new LoginException("Nao existe uma pessoa cadastrada com esse usuario");

        if (usuario.getSenha().isBlank() || !usuario.getSenha().equals(senha))
            throw new LoginException("Nao existe uma pessoa cadastrada com estas credenciais");

        Voluntario voluntario = null;
        Idoso idoso = null;
        if (usuario.getPerfil().equals("VOLUNTARIO"))
            voluntario = buscarVoluntarioUseCase.execute(idUsuario);
        else if (usuario.getPerfil().equals("IDOSO"))
            idoso = buscarIdosoUseCase.execute(idUsuario);

        List<Servico> servico;
        if (voluntario != null)
            servico = buscarServicoUseCase.executeByVoluntario(voluntario.getId());
        else if (idoso != null)
            servico = buscarServicoUseCase.executeByIdoso(idoso.getId());
        else
            throw new LoginException("Nao existe um perfil (idoso ou voluntario) cadastrado para este usuario");

        LOG.info("Fim - Login");

        return LoginResponseDTOMapper.fromEntities(usuario, voluntario, idoso, servico);
    }

}
