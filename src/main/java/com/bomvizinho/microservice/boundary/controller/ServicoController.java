package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.application.usecase.AlterarServicoUseCase;
import com.bomvizinho.microservice.application.usecase.CriarServicoUseCase;
import com.bomvizinho.microservice.application.usecase.DeletarServicoUseCase;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.ServicoVoluntarioRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.response.login.MessageResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/servico")
public class ServicoController {

    private final DeletarServicoUseCase deletarServicoUseCase;
    private final CriarServicoUseCase criarServicoUseCase;
    private final AlterarServicoUseCase alterarServicoUseCase;

    public ServicoController(DeletarServicoUseCase deletarServicoUseCase,
                             CriarServicoUseCase criarServicoUseCase,
                             AlterarServicoUseCase alterarServicoUseCase) {
        this.deletarServicoUseCase = deletarServicoUseCase;
        this.criarServicoUseCase = criarServicoUseCase;
        this.alterarServicoUseCase = alterarServicoUseCase;
    }

    @PostMapping
    @Operation(summary = "Criar serviço")
    public ResponseEntity<MessageResponseDTO> criarServico(@RequestBody ServicoRequestDTO servicoRequestDTO) {
        criarServicoUseCase.execute(servicoRequestDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Servico criado com sucesso!")
                .build());
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
    public ResponseEntity<MessageResponseDTO> atualizarServico(@RequestBody ServicoVoluntarioRequestDTO servicoVoluntarioRequestDTO) {
        alterarServicoUseCase.execute(servicoVoluntarioRequestDTO);
        return ResponseEntity.ok(MessageResponseDTO.Builder
                .aMessageDTO()
                    .withMessage("Servico alterado com sucesso!")
                .build());
    }

}
