package com.bomvizinho.microservice.boundary.controller.dto.request.servico.idoso.idoso;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServicoIdosoRequestDTO {

    private String numero;
    private String tipoServico;
    private String dataInicio;
    private String dataFim;
    private VoluntarioServicoRequestDTO voluntarioServicoRequestDTO;

    public ServicoIdosoRequestDTO() {
    }

    @JsonCreator
    public ServicoIdosoRequestDTO(String numero, String tipoServico, String dataInicio,
                                  String dataFim, VoluntarioServicoRequestDTO voluntarioServicoRequestDTO) {
        this.numero = numero;
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.voluntarioServicoRequestDTO = voluntarioServicoRequestDTO;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public VoluntarioServicoRequestDTO getVoluntarioServicoDTO() {
        return voluntarioServicoRequestDTO;
    }

    public void setVoluntarioServicoDTO(VoluntarioServicoRequestDTO voluntarioServicoRequestDTO) {
        this.voluntarioServicoRequestDTO = voluntarioServicoRequestDTO;
    }

    public static final class Builder {
        private String numero;
        private String tipoServico;
        private String dataInicio;
        private String dataFim;
        private VoluntarioServicoRequestDTO voluntarioServicoRequestDTO;

        private Builder() {
        }

        public static Builder aServicoDTO() {
            return new Builder();
        }

        public Builder withNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public Builder withTipoServico(String tipoServico) {
            this.tipoServico = tipoServico;
            return this;
        }

        public Builder withDataInicio(String dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder withDataFim(String dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public Builder withVoluntarioServicoDTO(VoluntarioServicoRequestDTO voluntarioServicoRequestDTO) {
            this.voluntarioServicoRequestDTO = voluntarioServicoRequestDTO;
            return this;
        }

        public ServicoIdosoRequestDTO build() {
            return new ServicoIdosoRequestDTO(numero, tipoServico, dataInicio, dataFim, voluntarioServicoRequestDTO);
        }
    }

}
