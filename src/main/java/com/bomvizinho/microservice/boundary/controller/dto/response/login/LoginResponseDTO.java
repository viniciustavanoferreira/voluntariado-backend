package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class LoginResponseDTO {

    private UsuarioResponseDTO usuarioResponseDTO;
    private VoluntarioResponseDTO voluntarioResponseDTO;
    private IdosoResponseDTO idosoResponseDTO;
    private List<ServicoResponseDTO> servicoResponseDTOList;

    @JsonCreator

    public LoginResponseDTO(UsuarioResponseDTO usuarioResponseDTO, VoluntarioResponseDTO voluntarioResponseDTO,
                            IdosoResponseDTO idosoResponseDTO, List<ServicoResponseDTO> servicoResponseDTOList) {
        this.usuarioResponseDTO = usuarioResponseDTO;
        this.voluntarioResponseDTO = voluntarioResponseDTO;
        this.idosoResponseDTO = idosoResponseDTO;
        this.servicoResponseDTOList = servicoResponseDTOList;
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

    public List<ServicoResponseDTO> getServicoResponseDTOList() {
        return servicoResponseDTOList;
    }

    public void setServicoResponseDTOList(List<ServicoResponseDTO> servicoResponseDTOList) {
        this.servicoResponseDTOList = servicoResponseDTOList;
    }

    public static final class Builder {
        private UsuarioResponseDTO usuarioResponseDTO;
        private VoluntarioResponseDTO voluntarioResponseDTO;
        private IdosoResponseDTO idosoResponseDTO;
        private List<ServicoResponseDTO> servicoResponseDTOList;

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

        public Builder withServicoResponseDTOList(List<ServicoResponseDTO> servicoResponseDTOList) {
            this.servicoResponseDTOList = servicoResponseDTOList;
            return this;
        }

        public LoginResponseDTO build() {
            return new LoginResponseDTO(usuarioResponseDTO, voluntarioResponseDTO, idosoResponseDTO, servicoResponseDTOList);
        }
    }

}
