package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.boundary.controller.dto.request.servico.ServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.servico.idoso.idoso.IdosoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.servico.idoso.idoso.ServicoIdosoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.servico.idoso.idoso.VoluntarioServicoRequestDTO;
import com.bomvizinho.microservice.boundary.controller.dto.request.servico.voluntario.voluntario.VoluntarioRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/servico")
public class ServicoController {

    @GetMapping("/idoso/email/{email}")
    public ResponseEntity<IdosoRequestDTO> buscarServicoIdoso(@PathVariable("email") String email) {
        return ResponseEntity.ok(IdosoRequestDTO.Builder
                .anIdosoDTO()
                .withEmail("vinicius-titio@etec.sp.gov.br")
                .withCep("99999-999")
                .withNome("Vini Titio")
                .withDataNascimento("01/01/1940")
                .withUsuario("vinicius-titio")
                .withTelefone("17-99999-9999")
                .withServicoDTOList(List.of(
                        ServicoIdosoRequestDTO.Builder.aServicoDTO()
                                .withNumero("1")
                                .withTipoServico("Troca de lâmpada")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioServicoDTO(VoluntarioServicoRequestDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Eustáquio Mello")
                                        .withEmail("eus@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build(),
                        ServicoIdosoRequestDTO.Builder.aServicoDTO()
                                .withNumero("2")
                                .withTipoServico("Troca de resistência do chuveiro")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioServicoDTO(VoluntarioServicoRequestDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Melica Teams")
                                        .withEmail("melli@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build()))
                .build());
    }

    @GetMapping("/voluntario/email/{email}")
    public ResponseEntity<VoluntarioRequestDTO> buscarServicoVoluntario(@PathVariable("email") String email) {
        return ResponseEntity.ok(VoluntarioRequestDTO.Builder
                .aVoluntarioDTO()
                    .withNome("Eustáquio Mello")
                    .withEmail("eus@gmail.com")
                    .withTelefone("17-99999-9999")
                .build());
    }

    @DeleteMapping("/codigo-servico/{codigo-servico}")
    public ResponseEntity<String> deletarServico(@PathVariable("codigo-servico") String codigoServico) {
        return ResponseEntity.ok("Serviço deletado com sucesso!");
    }

    @PutMapping
    public ResponseEntity<String> atualizarServico(@RequestBody ServicoRequestDTO servicoRequestDTO) {
        return ResponseEntity.ok("Serviço atualizado com sucesso!");
    }

}
