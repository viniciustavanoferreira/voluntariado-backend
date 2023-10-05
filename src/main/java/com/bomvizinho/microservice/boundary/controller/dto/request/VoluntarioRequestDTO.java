package com.bomvizinho.microservice.boundary.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class VoluntarioRequestDTO {

    private String preferencia;
    private String habilidade;
    private UsuarioRequestDTO usuarioRequestDTO;

    @JsonCreator

    public VoluntarioRequestDTO(String preferencia, String habilidade, UsuarioRequestDTO usuarioRequestDTO) {
        this.preferencia = preferencia;
        this.habilidade = habilidade;
        this.usuarioRequestDTO = usuarioRequestDTO;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public UsuarioRequestDTO getUsuarioRequestDTO() {
        return usuarioRequestDTO;
    }

    public void setUsuarioRequestDTO(UsuarioRequestDTO usuarioRequestDTO) {
        this.usuarioRequestDTO = usuarioRequestDTO;
    }

    public static final class Builder {
        private String preferencia;
        private String habilidade;
        private UsuarioRequestDTO usuarioRequestDTO;

        private Builder() {
        }

        public static Builder aVoluntarioRequestDTO() {
            return new Builder();
        }

        public Builder withPreferencia(String preferencia) {
            this.preferencia = preferencia;
            return this;
        }

        public Builder withHabilidade(String habilidade) {
            this.habilidade = habilidade;
            return this;
        }

        public Builder withUsuarioRequestDTO(UsuarioRequestDTO usuarioRequestDTO) {
            this.usuarioRequestDTO = usuarioRequestDTO;
            return this;
        }

        public VoluntarioRequestDTO build() {
            return new VoluntarioRequestDTO(preferencia, habilidade, usuarioRequestDTO);
        }
    }

}
