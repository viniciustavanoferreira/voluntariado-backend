package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.application.usecase.AlterarServicoUseCase;
import com.bomvizinho.microservice.application.usecase.BuscarTodosServicosElegiveisUseCase;
import com.bomvizinho.microservice.application.usecase.CriarServicoUseCase;
import com.bomvizinho.microservice.application.usecase.DeletarServicoUseCase;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoVoluntarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.MessageResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoIdosoResponseDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.ServicoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/servico")
public class ServicoController {

    private final DeletarServicoUseCase deletarServicoUseCase;
    private final CriarServicoUseCase criarServicoUseCase;
    private final AlterarServicoUseCase alterarServicoUseCase;
    private final BuscarTodosServicosElegiveisUseCase buscarTodosServicosElegiveisUseCase;

    public ServicoController(DeletarServicoUseCase deletarServicoUseCase,
                             CriarServicoUseCase criarServicoUseCase,
                             AlterarServicoUseCase alterarServicoUseCase,
                             BuscarTodosServicosElegiveisUseCase buscarTodosServicosElegiveisUseCase) {
        this.deletarServicoUseCase = deletarServicoUseCase;
        this.criarServicoUseCase = criarServicoUseCase;
        this.alterarServicoUseCase = alterarServicoUseCase;
        this.buscarTodosServicosElegiveisUseCase = buscarTodosServicosElegiveisUseCase;
    }

    @PostMapping
    @Operation(summary = "Criar serviço")
    public ResponseEntity<ServicoResponseDTO> criarServico(@RequestBody ServicoRequestDTO servicoRequestDTO) {
        return ResponseEntity.ok(criarServicoUseCase.execute(servicoRequestDTO));
    }

    @DeleteMapping("/codigo-servico/{codigo-servico}")
    @Operation(summary = "Deletar serviço")
    public ResponseEntity<MessageResponseDTO> deletarServico(@PathVariable("codigo-servico") Long codigoServico) {
        deletarServicoUseCase.execute(codigoServico);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Servico deletado com sucesso!")
                .build());
    }

    @PutMapping
    @Operation(summary = "Atualizar serviço (dados serviço ou vincular voluntário)")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@RequestBody ServicoVoluntarioRequestDTO servicoVoluntarioRequestDTO) {
        return ResponseEntity.ok(alterarServicoUseCase.execute(servicoVoluntarioRequestDTO));
    }

    @GetMapping
    @Operation(summary = "Buscar todos os serviços elegíveis (que não possuem voluntários associados) cadastrados no sistema")
    public ResponseEntity<List<ServicoIdosoResponseDTO>> buscarTodosServicos() {
        return ResponseEntity.ok(buscarTodosServicosElegiveisUseCase.execute());
    }

}
