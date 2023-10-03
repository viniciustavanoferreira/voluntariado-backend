package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Timestamp;

public class ServicoResponseDTO {

    private Long id;
    private Timestamp dataHoraFim;
    private Timestamp dataHoraInicio;
    private String destino;
    private String tipoServico;
    private String status;

    @JsonCreator

    public ServicoResponseDTO(Long id, Timestamp dataHoraFim,
                              Timestamp dataHoraInicio, String destino,
                              String tipoServico, String status) {
        this.id = id;
        this.dataHoraFim = dataHoraFim;
        this.dataHoraInicio = dataHoraInicio;
        this.destino = destino;
        this.tipoServico = tipoServico;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Timestamp dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public Timestamp getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Timestamp dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static final class Builder {
        private Long id;
        private Timestamp dataHoraFim;
        private Timestamp dataHoraInicio;
        private String destino;
        private String tipoServico;
        private String status;

        private Builder() {
        }

        public static Builder aServicoResponseDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withDataHoraFim(Timestamp dataHoraFim) {
            this.dataHoraFim = dataHoraFim;
            return this;
        }

        public Builder withDataHoraInicio(Timestamp dataHoraInicio) {
            this.dataHoraInicio = dataHoraInicio;
            return this;
        }

        public Builder withDestino(String destino) {
            this.destino = destino;
            return this;
        }

        public Builder withTipoServico(String tipoServico) {
            this.tipoServico = tipoServico;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public ServicoResponseDTO build() {
            return new ServicoResponseDTO(id, dataHoraFim, dataHoraInicio, destino, tipoServico, status);
        }
    }

}
