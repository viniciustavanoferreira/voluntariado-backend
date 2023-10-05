package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.VoluntarioRequestDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Voluntario;

public class VoluntarioRequestDTOMapper {

    public static Voluntario toVoluntarioEntity(Voluntario voluntario, VoluntarioRequestDTO voluntarioRequestDTO) {
        voluntario.setHabilidade(voluntario.getHabilidade());
        voluntario.setPreferencia(voluntarioRequestDTO.getPreferencia());
        voluntario
            .setUsuarioVoluntario(UsuarioRequestDTOMapper
                    .toUsuarioEntity(voluntarioRequestDTO.getUsuarioRequestDTO()));
        return voluntario;
    }

}
