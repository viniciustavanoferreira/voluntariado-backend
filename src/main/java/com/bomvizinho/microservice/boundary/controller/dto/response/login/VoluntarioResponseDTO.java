package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

public class VoluntarioResponseDTO {

    private Long id;
    private String habilidade;
    private String preferencia;

    @JsonCreator

    public VoluntarioResponseDTO(Long id, String habilidade, String preferencia) {
        this.id = id;
        this.habilidade = habilidade;
        this.preferencia = preferencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public static final class Builder {
        private Long id;
        private String habilidade;
        private String preferencia;

        private Builder() {
        }

        public static Builder aVoluntarioResponseDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withHabilidade(String habilidade) {
            this.habilidade = habilidade;
            return this;
        }

        public Builder withPreferencia(String preferencia) {
            this.preferencia = preferencia;
            return this;
        }

        public VoluntarioResponseDTO build() {
            return new VoluntarioResponseDTO(id, habilidade, preferencia);
        }
    }

}
