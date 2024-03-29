package com.bomvizinho.microservice.boundary.controller.dto.request.servico;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServicoRequestDTO {

    private String numero;
    private String tipoServico;
    private String dataInicio;
    private String dataFim;

    public ServicoRequestDTO() {
    }

    @JsonCreator
    public ServicoRequestDTO(String numero, String tipoServico,
                             String dataInicio, String dataFim) {
        this.numero = numero;
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    public static final class Builder {
        private String numero;
        private String tipoServico;
        private String dataInicio;
        private String dataFim;

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

        public ServicoRequestDTO build() {
            ServicoRequestDTO servicoRequestDTO = new ServicoRequestDTO();
            servicoRequestDTO.setNumero(numero);
            servicoRequestDTO.setTipoServico(tipoServico);
            servicoRequestDTO.setDataInicio(dataInicio);
            servicoRequestDTO.setDataFim(dataFim);
            return servicoRequestDTO;
        }
    }

}
