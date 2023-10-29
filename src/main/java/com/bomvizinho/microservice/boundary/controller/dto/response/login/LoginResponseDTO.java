package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class LoginResponseDTO {

    private UsuarioResponseDTO usuarioResponseDTO;
    private VoluntarioResponseDTO voluntarioResponseDTO;
    private IdosoResponseDTO idosoResponseDTO;
    @JsonProperty("servicoResponseDTOList")
    private List<ServicoAssociadoResponseDTO> servicoAssociadoResponseDTOList;

    @JsonCreator
    public LoginResponseDTO(UsuarioResponseDTO usuarioResponseDTO, VoluntarioResponseDTO voluntarioResponseDTO,
                            IdosoResponseDTO idosoResponseDTO, List<ServicoAssociadoResponseDTO> servicoAssociadoResponseDTOList) {
        this.usuarioResponseDTO = usuarioResponseDTO;
        this.voluntarioResponseDTO = voluntarioResponseDTO;
        this.idosoResponseDTO = idosoResponseDTO;
        this.servicoAssociadoResponseDTOList = servicoAssociadoResponseDTOList;
    }

    public UsuarioResponseDTO getUsuarioResponseDTO() {
        return usuarioResponseDTO;
    }

    public void setUsuarioResponseDTO(UsuarioResponseDTO usuarioResponseDTO) {
        this.usuarioResponseDTO = usuarioResponseDTO;
    }

    public VoluntarioResponseDTO getVoluntarioResponseDTO() {
        return voluntarioResponseDTO;
    }

    public void setVoluntarioResponseDTO(VoluntarioResponseDTO voluntarioResponseDTO) {
        this.voluntarioResponseDTO = voluntarioResponseDTO;
    }

    public IdosoResponseDTO getIdosoResponseDTO() {
        return idosoResponseDTO;
    }

    public void setIdosoResponseDTO(IdosoResponseDTO idosoResponseDTO) {
        this.idosoResponseDTO = idosoResponseDTO;
    }

    public List<ServicoAssociadoResponseDTO> getServicoAssociadoResponseDTOList() {
        return servicoAssociadoResponseDTOList;
    }

    public void setServicoAssociadoResponseDTOList(List<ServicoAssociadoResponseDTO> servicoAssociadoResponseDTOList) {
        this.servicoAssociadoResponseDTOList = servicoAssociadoResponseDTOList;
    }

    public static final class Builder {
        private UsuarioResponseDTO usuarioResponseDTO;
        private VoluntarioResponseDTO voluntarioResponseDTO;
        private IdosoResponseDTO idosoResponseDTO;
        private List<ServicoAssociadoResponseDTO> servicoAssociadoResponseDTOList;

        private Builder() {
        }

        public static Builder aLoginResponseDTO() {
            return new Builder();
        }

        public Builder withUsuarioResponseDTO(UsuarioResponseDTO usuarioResponseDTO) {
            this.usuarioResponseDTO = usuarioResponseDTO;
            return this;
        }

        public Builder withVoluntarioResponseDTO(VoluntarioResponseDTO voluntarioResponseDTO) {
            this.voluntarioResponseDTO = voluntarioResponseDTO;
            return this;
        }

        public Builder withIdosoResponseDTO(IdosoResponseDTO idosoResponseDTO) {
            this.idosoResponseDTO = idosoResponseDTO;
            return this;
        }

        public Builder withServicoAssociadoResponseDTOList(List<ServicoAssociadoResponseDTO> servicoAssociadoResponseDTOList) {
            this.servicoAssociadoResponseDTOList = servicoAssociadoResponseDTOList;
            return this;
        }

        public LoginResponseDTO build() {
            return new LoginResponseDTO(usuarioResponseDTO, voluntarioResponseDTO, idosoResponseDTO, servicoAssociadoResponseDTOList);
        }
    }

}
