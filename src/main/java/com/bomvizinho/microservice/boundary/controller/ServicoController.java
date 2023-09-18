package com.bomvizinho.microservice.boundary.controller;

import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.IdosoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.ServicoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.idoso.VoluntarioServicoDTO;
import com.bomvizinho.microservice.boundary.controller.dto.servico.voluntario.VoluntarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/servico")
public class ServicoController {

    @GetMapping(path = { "/idoso/{email}" })
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
                        ServicoDTO.Builder.aServicoDTO()
                                .withTipoServico("Troca de lâmpada")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioDTO(VoluntarioServicoDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Eustáquio Mello")
                                        .withEmail("eus@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build(),
                        ServicoDTO.Builder.aServicoDTO()
                                .withTipoServico("Troca de resistência do chuveiro")
                                .withDataInicio("01/01/1940")
                                .withDataFim("01/01/1940")
                                .withVoluntarioDTO(VoluntarioServicoDTO.Builder
                                        .aVoluntarioDTO()
                                        .withNome("Melica Teams")
                                        .withEmail("melli@gmail.com")
                                        .withTelefone("17-99999-9999")
                                        .build())
                                .build()))
                .build());
    }

    @GetMapping(path = { "/voluntario/{email}" })
    public ResponseEntity<VoluntarioDTO> buscarServicoVoluntario(@PathVariable("email") String email) {
        return ResponseEntity.ok(VoluntarioDTO.Builder
                .aVoluntarioDTO()
                .withNome("Eustáquio Mello")
                .withEmail("eus@gmail.com")
                .withTelefone("17-99999-9999")
                .build());
    }

}
