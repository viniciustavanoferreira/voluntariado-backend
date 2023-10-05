package com.bomvizinho.microservice.boundary.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Timestamp;

public class ServicoVoluntarioRequestDTO {

    private Long codigoServico;
    private String tipoServico;
    private Timestamp dataInicio;
    private Timestamp dataFim;
    private String ordem;
    private String destino;
    private String status;
    private String idUsuarioVoluntario;

    @JsonCreator
    public ServicoVoluntarioRequestDTO(Long codigoServico, String tipoServico,
                                       Timestamp dataInicio, Timestamp dataFim,
                                       String ordem, String destino, String status,
                                       String idUsuarioVoluntario) {
        this.codigoServico = codigoServico;
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ordem = ordem;
        this.destino = destino;
        this.status = status;
        this.idUsuarioVoluntario = idUsuarioVoluntario;
    }

    public Long getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(Long codigoServico) {
        this.codigoServico = codigoServico;
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

    public String getIdUsuarioVoluntario() {
        return idUsuarioVoluntario;
    }

    public void setIdUsuarioVoluntario(String idUsuarioVoluntario) {
        this.idUsuarioVoluntario = idUsuarioVoluntario;
    }

    public static final class Builder {
        private Long codigoServico;
        private String tipoServico;
        private Timestamp dataInicio;
        private Timestamp dataFim;
        private String ordem;
        private String destino;
        private String status;
        private String idUsuarioVoluntario;

        private Builder() {
        }

        public static Builder aServicoVoluntarioRequestDTO() {
            return new Builder();
        }

        public Builder withCodigoServico(Long codigoServico) {
            this.codigoServico = codigoServico;
            return this;
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

        public Builder withIdUsuarioVoluntario(String idUsuarioVoluntario) {
            this.idUsuarioVoluntario = idUsuarioVoluntario;
            return this;
        }

        public ServicoVoluntarioRequestDTO build() {
            return new ServicoVoluntarioRequestDTO(codigoServico, tipoServico, dataInicio, dataFim, ordem, destino, status, idUsuarioVoluntario);
        }
    }

}
