package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

public class IdosoResponseDTO {

    private Long id;
    private String assistenciaRequerida;
    private String condicaoSaude;
    private String preferenciaDia;

    @JsonCreator

    public IdosoResponseDTO(Long id, String assistenciaRequerida, String condicaoSaude, String preferenciaDia) {
        this.id = id;
        this.assistenciaRequerida = assistenciaRequerida;
        this.condicaoSaude = condicaoSaude;
        this.preferenciaDia = preferenciaDia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssistenciaRequerida() {
        return assistenciaRequerida;
    }

    public void setAssistenciaRequerida(String assistenciaRequerida) {
        this.assistenciaRequerida = assistenciaRequerida;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }

    public String getPreferenciaDia() {
        return preferenciaDia;
    }

    public void setPreferenciaDia(String preferenciaDia) {
        this.preferenciaDia = preferenciaDia;
    }

    public static final class Builder {
        private Long id;
        private String assistenciaRequerida;
        private String condicaoSaude;
        private String preferenciaDia;

        private Builder() {
        }

        public static Builder anIdosoResponseDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withAssistenciaRequerida(String assistenciaRequerida) {
            this.assistenciaRequerida = assistenciaRequerida;
            return this;
        }

        public Builder withCondicaoSaude(String condicaoSaude) {
            this.condicaoSaude = condicaoSaude;
            return this;
        }

        public Builder withPreferenciaDia(String preferenciaDia) {
            this.preferenciaDia = preferenciaDia;
            return this;
        }

        public IdosoResponseDTO build() {
            return new IdosoResponseDTO(id, assistenciaRequerida, condicaoSaude, preferenciaDia);
        }
    }

}
