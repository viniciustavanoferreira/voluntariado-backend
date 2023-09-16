package com.bomvizinho.microservice.dto.idoso;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class IdosoDTO {

    private String nome;

    private String dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String usuario;
    private String senha;

    private List<ServicoDTO> servicoDTOList;

    public IdosoDTO() {
    }

    @JsonCreator
    public IdosoDTO(String nome, String dataNascimento,
                    String email, String telefone, String cep, String endereco,
                    String usuario, String senha, List<ServicoDTO> servicoDTOList) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
        this.servicoDTOList = servicoDTOList;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<ServicoDTO> getServicoDTOList() {
        return servicoDTOList;
    }

    public void setServicoDTOList(List<ServicoDTO> servicoDTOList) {
        this.servicoDTOList = servicoDTOList;
    }

    public static final class Builder {
        private String nome;
        private String dataNascimento;
        private String email;
        private String telefone;
        private String cep;
        private String endereco;
        private String usuario;
        private String senha;
        private List<ServicoDTO> servicoDTOList;

        private Builder() {
        }

        public static Builder anIdosoDTO() {
            return new Builder();
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder withCep(String cep) {
            this.cep = cep;
            return this;
        }

        public Builder withEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder withUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder withServicoDTOList(List<ServicoDTO> servicoDTOList) {
            this.servicoDTOList = servicoDTOList;
            return this;
        }

        public IdosoDTO build() {
            IdosoDTO idosoDTO = new IdosoDTO();
            idosoDTO.setNome(nome);
            idosoDTO.setDataNascimento(dataNascimento);
            idosoDTO.setEmail(email);
            idosoDTO.setTelefone(telefone);
            idosoDTO.setCep(cep);
            idosoDTO.setEndereco(endereco);
            idosoDTO.setUsuario(usuario);
            idosoDTO.setSenha(senha);
            idosoDTO.setServicoDTOList(servicoDTOList);
            return idosoDTO;
        }
    }

}
