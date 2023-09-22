package com.bomvizinho.microservice.boundary.controller.dto.servico.idoso;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServicoIdosoDTO {

    private String numero;
    private String tipoServico;
    private String dataInicio;
    private String dataFim;
    private VoluntarioServicoDTO voluntarioServicoDTO;

    public ServicoIdosoDTO() {
    }

    @JsonCreator
    public ServicoIdosoDTO(String numero, String tipoServico, String dataInicio,
                           String dataFim, VoluntarioServicoDTO voluntarioServicoDTO) {
        this.numero = numero;
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.voluntarioServicoDTO = voluntarioServicoDTO;
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

    public VoluntarioServicoDTO getVoluntarioServicoDTO() {
        return voluntarioServicoDTO;
    }

    public void setVoluntarioServicoDTO(VoluntarioServicoDTO voluntarioServicoDTO) {
        this.voluntarioServicoDTO = voluntarioServicoDTO;
    }

    public static final class Builder {
        private String numero;
        private String tipoServico;
        private String dataInicio;
        private String dataFim;
        private VoluntarioServicoDTO voluntarioServicoDTO;

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

        public Builder withVoluntarioServicoDTO(VoluntarioServicoDTO voluntarioServicoDTO) {
            this.voluntarioServicoDTO = voluntarioServicoDTO;
            return this;
        }

        public ServicoIdosoDTO build() {
            return new ServicoIdosoDTO(numero, tipoServico, dataInicio, dataFim, voluntarioServicoDTO);
        }
    }

}
