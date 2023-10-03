package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.LoginException;
import com.bomvizinho.microservice.boundary.controller.dto.request.UsuarioDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.LoginResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.mapper.LoginResponseDTOMapper;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.mapper.UsuarioEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoginUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(LoginUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;
    private final BuscarServicoUseCase buscarServicoUseCase;

    public LoginUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                        BuscarVoluntarioUseCase buscarVoluntarioUseCase,
                        BuscarServicoUseCase buscarServicoUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
        this.buscarServicoUseCase = buscarServicoUseCase;
    }

    public LoginResponseDTO execute(final String email, final String password) {
        LOG.info("Inicio - Login");

        final var usuario = buscarUsuarioUseCase.execute(email);
        if (usuario == null || usuario.getEmail().isBlank())
            throw new LoginException("Nao existe um usuario cadastrado com este email");

        if (usuario.getSenha().isBlank() || !usuario.getSenha().equals(password))
            throw new LoginException("Nao existe um usuario cadastrado com estas credenciais");

        Voluntario voluntario = null;
        Idoso idoso = null;
        if (usuario.getTipoPerfil().equals("VOLUNTARIO"))
            voluntario = buscarVoluntarioUseCase.execute(usuario.getEmail());
//        else
//            //BuscarServicoIdosoUseCase
        //TODO: implementar a busca de idosos e seus serviços

        List<Servico> servico = new ArrayList<>();
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
