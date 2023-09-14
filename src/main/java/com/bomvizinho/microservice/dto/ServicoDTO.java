package com.bomvizinho.microservice.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServicoDTO {

    private String tipoServico;
    private String dataInicio;
    private String dataFim;
    private VoluntarioDTO voluntarioDTO;

    public ServicoDTO() {
    }

    @JsonCreator
    public ServicoDTO(String tipoServico, String dataInicio,
                      String dataFim, VoluntarioDTO voluntarioDTO) {
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.voluntarioDTO = voluntarioDTO;
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

    public VoluntarioDTO getVoluntarioDTO() {
        return voluntarioDTO;
    }

    public void setVoluntarioDTO(VoluntarioDTO voluntarioDTO) {
        this.voluntarioDTO = voluntarioDTO;
    }

    public static final class Builder {
        private String tipoServico;
        private String dataInicio;
        private String dataFim;
        private VoluntarioDTO voluntarioDTO;

        private Builder() {
        }

        public static Builder aServicoDTO() {
            return new Builder();
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

        public Builder withVoluntarioDTO(VoluntarioDTO voluntarioDTO) {
            this.voluntarioDTO = voluntarioDTO;
            return this;
        }

        public ServicoDTO build() {
            ServicoDTO servicoDTO = new ServicoDTO();
            servicoDTO.setTipoServico(tipoServico);
            servicoDTO.setDataInicio(dataInicio);
            servicoDTO.setDataFim(dataFim);
            servicoDTO.setVoluntarioDTO(voluntarioDTO);
            return servicoDTO;
        }
    }

}
