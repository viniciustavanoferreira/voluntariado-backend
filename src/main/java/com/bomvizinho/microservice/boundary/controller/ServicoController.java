package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.boundary.controller.dto.servico.ServicoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.IdosoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.ServicoIdosoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.VoluntarioServicoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.voluntario.VoluntarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/servico")
public class ServicoController {

    @GetMapping("/idoso/email/{email}")
    public ResponseEntity<IdosoDTO> buscarServicoIdoso(@PathVariable("email") String email) {
        return ResponseEntity.ok(IdosoDTO.Builder
                .anIdosoDTO()
                .withEmail("vinicius-titio@etec.sp.gov.br")
                .withCep("99999-999")
                .withNome("Vini Titio")
                .withDataNascimento("01/01/1940")
                .withUsuario("vinicius-titio")
                .withTelefone("17-99999-9999")
                .withServicoDTOList(List.of(
                        ServicoIdosoDTO.Builder.aServicoDTO()
                                .withNumero("1")
                                .withTipoServico("Troca de lâmpada")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioServicoDTO(VoluntarioServicoDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Eustáquio Mello")
                                        .withEmail("eus@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build(),
                        ServicoIdosoDTO.Builder.aServicoDTO()
                                .withNumero("2")
                                .withTipoServico("Troca de resistência do chuveiro")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioServicoDTO(VoluntarioServicoDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Melica Teams")
                                        .withEmail("melli@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build()))
                .build());
    }

    @GetMapping("/voluntario/email/{email}")
    public ResponseEntity<VoluntarioDTO> buscarServicoVoluntario(@PathVariable("email") String email) {
        return ResponseEntity.ok(VoluntarioDTO.Builder
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
    public ResponseEntity<String> atualizarServico(@RequestBody ServicoDTO servicoDTO) {
        return ResponseEntity.ok("Serviço atualizado com sucesso!");
    }

}
