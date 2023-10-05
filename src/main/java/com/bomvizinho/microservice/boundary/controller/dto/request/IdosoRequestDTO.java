package com.bomvizinho.microservice.boundary.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.Column;

public class IdosoRequestDTO {

    private String condicaoSaude;
    private String assistenciaRequerida;
    private String preferenciaDia;
    private UsuarioRequestDTO usuarioRequestDTO;

    @JsonCreator

    public IdosoRequestDTO(String condicaoSaude, String assistenciaRequerida,
                           String preferenciaDia, UsuarioRequestDTO usuarioRequestDTO) {
        this.condicaoSaude = condicaoSaude;
        this.assistenciaRequerida = assistenciaRequerida;
        this.preferenciaDia = preferenciaDia;
        this.usuarioRequestDTO = usuarioRequestDTO;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }

    public String getAssistenciaRequerida() {
        return assistenciaRequerida;
    }

    public void setAssistenciaRequerida(String assistenciaRequerida) {
        this.assistenciaRequerida = assistenciaRequerida;
    }

    public String getPreferenciaDia() {
        return preferenciaDia;
    }

    public void setPreferenciaDia(String preferenciaDia) {
        this.preferenciaDia = preferenciaDia;
    }

    public UsuarioRequestDTO getUsuarioRequestDTO() {
        return usuarioRequestDTO;
    }

    public void setUsuarioRequestDTO(UsuarioRequestDTO usuarioRequestDTO) {
        this.usuarioRequestDTO = usuarioRequestDTO;
    }

    public static final class Builder {
        private String condicaoSaude;
        private String assistenciaRequerida;
        private String preferenciaDia;
        private UsuarioRequestDTO usuarioRequestDTO;

        private Builder() {
        }

        public static Builder anIdosoRequestDTO() {
            return new Builder();
        }

        public Builder withCondicaoSaude(String condicaoSaude) {
            this.condicaoSaude = condicaoSaude;
            return this;
        }

        public Builder withAssistenciaRequerida(String assistenciaRequerida) {
            this.assistenciaRequerida = assistenciaRequerida;
            return this;
        }

        public Builder withPreferenciaDia(String preferenciaDia) {
            this.preferenciaDia = preferenciaDia;
            return this;
        }

        public Builder withUsuarioRequestDTO(UsuarioRequestDTO usuarioRequestDTO) {
            this.usuarioRequestDTO = usuarioRequestDTO;
            return this;
        }

        public IdosoRequestDTO build() {
            return new IdosoRequestDTO(condicaoSaude, assistenciaRequerida, preferenciaDia, usuarioRequestDTO);
        }
    }

}
