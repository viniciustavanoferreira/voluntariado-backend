package com.bomvizinho.microservice.application.usecase;

import com.bomvizinho.microservice.application.exception.DeletarUsuarioException;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Servico;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeletarUsuarioUseCase {

    private static final Logger LOG = LoggerFactory.getLogger(DeletarUsuarioUseCase.class);
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final ManterUsuarioUseCase manterUsuarioUseCase;
    private final ManterServicoUseCase manterServicoUseCase;
    private final CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase;
    private final CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase;
    private final BuscarIdosoUseCase buscarIdosoUseCase;
    private final BuscarVoluntarioUseCase buscarVoluntarioUseCase;

    public DeletarUsuarioUseCase(BuscarUsuarioUseCase buscarUsuarioUseCase,
                                 ManterUsuarioUseCase manterUsuarioUseCase,
                                 ManterServicoUseCase manterServicoUseCase,
                                 CriarOuAlterarIdosoUseCase criarOuAlterarIdosoUseCase,
                                 CriarOuAlterarVoluntarioUseCase criarOuAlterarVoluntarioUseCase,
                                 BuscarIdosoUseCase buscarIdosoUseCase,
                                 BuscarVoluntarioUseCase buscarVoluntarioUseCase) {
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
        this.manterUsuarioUseCase = manterUsuarioUseCase;
        this.manterServicoUseCase = manterServicoUseCase;
        this.criarOuAlterarIdosoUseCase = criarOuAlterarIdosoUseCase;
        this.criarOuAlterarVoluntarioUseCase = criarOuAlterarVoluntarioUseCase;
        this.buscarIdosoUseCase = buscarIdosoUseCase;
        this.buscarVoluntarioUseCase = buscarVoluntarioUseCase;
    }

    public void execute(final Long codigoUsuario) {
        LOG.info("Inicio - Deletar usuario");

        final var usuario = buscarUsuarioUseCase.executeById(codigoUsuario);
        if (usuario == null)
            throw new DeletarUsuarioException("Nao existe usuario cadastrado para o codigo informado");

        Voluntario voluntario = null;
        Idoso idoso = null;
        if (usuario.getPerfil().equals("VOLUNTARIO"))
            voluntario = buscarVoluntarioUseCase.executeByUser(usuario.getIdUsuario());
        else if (usuario.getPerfil().equals("IDOSO"))
            idoso = buscarIdosoUseCase.executeByUser(usuario.getIdUsuario());

        List<Long> servicos;
        //TODO: realizar o delete cascade e refatorar para Iterable em deleteByIds;
        if (voluntario != null) {
            servicos = deletarVoluntario(voluntario);
        } else if (idoso != null) {
            servicos = deletarIdoso(idoso);
        } else
            throw new DeletarUsuarioException("Nao existe um perfil (idoso ou voluntario) cadastrado para este usuario");

        manterUsuarioUseCase.executeDelete(codigoUsuario);
        manterServicoUseCase.executeDeleteByList(servicos);

        LOG.info("Inicio - Deletar servico");
    }

    private List<Long> deletarIdoso(Idoso idoso) {
        var servicos = idoso.getServicoIdoso().stream()
                        .map(Servico::getId)
                        .toList();

        idoso.setUsuarioIdoso(null);
        idoso.setServicoIdoso(null);
        criarOuAlterarIdosoUseCase.execute(idoso);

        return servicos;
    }

    private List<Long> deletarVoluntario(Voluntario voluntario) {
        var servicos = voluntario.getServicoVoluntario().stream()
                        .map(Servico::getId)
                        .toList();

        voluntario.setUsuarioVoluntario(null);
        voluntario.setServicoVoluntario(null);
        criarOuAlterarVoluntarioUseCase.execute(voluntario);

        return servicos;
    }

}
