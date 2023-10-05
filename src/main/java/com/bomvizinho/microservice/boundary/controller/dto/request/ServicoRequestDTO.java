package com.bomvizinho.microservice.boundary.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Timestamp;

public class ServicoRequestDTO {

    private String tipoServico;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private String ordem;
    private String destino;
    private String status;
    private String idUsuarioIdoso;

    @JsonCreator

    public ServicoRequestDTO(String tipoServico, Timestamp dataInicio,
                             Timestamp dataFim, String ordem, String destino,
                             String status, String idUsuarioIdoso) {
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ordem = ordem;
        this.destino = destino;
        this.status = status;
        this.idUsuarioIdoso = idUsuarioIdoso;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUsuarioIdoso() {
        return idUsuarioIdoso;
    }

    public void setIdUsuarioIdoso(String idUsuarioIdoso) {
        this.idUsuarioIdoso = idUsuarioIdoso;
    }

    public static final class Builder {
        private String tipoServico;
        private Timestamp dataInicio;
        private Timestamp dataFim;
        private String ordem;
        private String destino;
        private String status;
        private String idUsuarioIdoso;

        private Builder() {
        }

        public static Builder aServicoRequestDTO() {
            return new Builder();
        }

        public Builder withTipoServico(String tipoServico) {
            this.tipoServico = tipoServico;
            return this;
        }

        public Builder withDataInicio(Timestamp dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder withDataFim(Timestamp dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public Builder withOrdem(String ordem) {
            this.ordem = ordem;
            return this;
        }

        public Builder withDestino(String destino) {
            this.destino = destino;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withIdUsuarioIdoso(String idUsuarioIdoso) {
            this.idUsuarioIdoso = idUsuarioIdoso;
            return this;
        }

        public ServicoRequestDTO build() {
            return new ServicoRequestDTO(tipoServico, dataInicio, dataFim, ordem, destino, status, idUsuarioIdoso);
        }
    }

}
