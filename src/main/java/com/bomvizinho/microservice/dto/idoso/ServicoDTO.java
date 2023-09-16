package com.bomvizinho.microservice.dto.idoso;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ServicoDTO {

    private String tipoServico;
    private String dataInicio;
    private String dataFim;
    private VoluntarioServicoDTO voluntarioServicoDTO;

    public ServicoDTO() {
    }

    @JsonCreator
    public ServicoDTO(String tipoServico, String dataInicio,
                      String dataFim, VoluntarioServicoDTO voluntarioServicoDTO) {
        this.tipoServico = tipoServico;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.voluntarioServicoDTO = voluntarioServicoDTO;
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

    public VoluntarioServicoDTO getVoluntarioDTO() {
        return voluntarioServicoDTO;
    }

    public void setVoluntarioDTO(VoluntarioServicoDTO voluntarioServicoDTO) {
        this.voluntarioServicoDTO = voluntarioServicoDTO;
    }

    public static final class Builder {
        private String tipoServico;
        private String dataInicio;
        private String dataFim;
        private VoluntarioServicoDTO voluntarioServicoDTO;

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

        public Builder withVoluntarioDTO(VoluntarioServicoDTO voluntarioServicoDTO) {
            this.voluntarioServicoDTO = voluntarioServicoDTO;
            return this;
        }

        public ServicoDTO build() {
            ServicoDTO servicoDTO = new ServicoDTO();
            servicoDTO.setTipoServico(tipoServico);
            servicoDTO.setDataInicio(dataInicio);
            servicoDTO.setDataFim(dataFim);
            servicoDTO.setVoluntarioDTO(voluntarioServicoDTO);
            return servicoDTO;
        }
    }

}
