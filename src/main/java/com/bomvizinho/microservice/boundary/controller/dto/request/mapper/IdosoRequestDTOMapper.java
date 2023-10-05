package com.bomvizinho.microservice.boundary.controller.dto.request.mapper;

import com.bomvizinho.microservice.boundary.controller.dto.request.IdosoRequestDTO;
import com.bomvizinho.microservice.infrastructure.dataprovider.entity.Idoso;

public class IdosoRequestDTOMapper {

    public static Idoso toIdosoEntity(Idoso idoso, IdosoRequestDTO idosoRequestDTO) {
        idoso.setAssistenciaRequerida(idosoRequestDTO.getAssistenciaRequerida());
        idoso.setCondicaoSaude(idosoRequestDTO.getCondicaoSaude());
        idoso.setPreferenciaDia(idosoRequestDTO.getPreferenciaDia());
        idoso
            .setUsuarioIdoso(UsuarioRequestDTOMapper
                    .toUsuarioEntity(idosoRequestDTO.getUsuarioRequestDTO()));
        return idoso;
    }

}
