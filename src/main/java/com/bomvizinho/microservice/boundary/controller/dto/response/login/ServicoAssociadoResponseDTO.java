package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Timestamp;

public class ServicoAssociadoResponseDTO {

    private Long id;
    private Timestamp dataHoraFim;
    private Timestamp dataHoraInicio;
    private String ordem;
    private String destino;
    private String tipoServico;
    private String status;
    private String idUsuarioIdoso;
    private String idUsuarioVoluntario;

    @JsonCreator
    public ServicoAssociadoResponseDTO(Long id, Timestamp dataHoraFim,
                                       Timestamp dataHoraInicio, String ordem,
                                       String destino, String tipoServico,
                                       String status, String idUsuarioIdoso,
                                       String idUsuarioVoluntario) {
        this.id = id;
        this.dataHoraFim = dataHoraFim;
        this.dataHoraInicio = dataHoraInicio;
        this.ordem = ordem;
        this.destino = destino;
        this.tipoServico = tipoServico;
        this.status = status;
        this.idUsuarioIdoso = idUsuarioIdoso;
        this.idUsuarioVoluntario = idUsuarioVoluntario;
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

    public String getIdUsuarioIdoso() {
        return idUsuarioIdoso;
    }

    public void setIdUsuarioIdoso(String idUsuarioIdoso) {
        this.idUsuarioIdoso = idUsuarioIdoso;
    }

    public String getIdUsuarioVoluntario() {
        return idUsuarioVoluntario;
    }

    public void setIdUsuarioVoluntario(String idUsuarioVoluntario) {
        this.idUsuarioVoluntario = idUsuarioVoluntario;
    }

    public static final class Builder {
        private Long id;
        private Timestamp dataHoraFim;
        private Timestamp dataHoraInicio;
        private String ordem;
        private String destino;
        private String tipoServico;
        private String status;
        private String idUsuarioIdoso;
        private String idUsuarioVoluntario;

        private Builder() {
        }

        public static Builder aServicoAssociadoResponseDTO() {
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

        public Builder withOrdem(String ordem) {
            this.ordem = ordem;
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

        public Builder withIdUsuarioIdoso(String idUsuarioIdoso) {
            this.idUsuarioIdoso = idUsuarioIdoso;
            return this;
        }

        public Builder withIdUsuarioVoluntario(String idUsuarioVoluntario) {
            this.idUsuarioVoluntario = idUsuarioVoluntario;
            return this;
        }

        public ServicoAssociadoResponseDTO build() {
            return new ServicoAssociadoResponseDTO(id, dataHoraFim, dataHoraInicio, ordem, destino, tipoServico, status, idUsuarioIdoso, idUsuarioVoluntario);
        }
    }

}
