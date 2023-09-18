package com.bomvizinho.microservice.boundary.controller.dto.servico.idoso;

import com.fasterxml.jackson.annotation.JsonCreator;

public class VoluntarioServicoDTO {

    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String usuario;
    private String senha;

    public VoluntarioServicoDTO() {
    }

    @JsonCreator
    public VoluntarioServicoDTO(String nome, String sobrenome, String dataNascimento, String email,
                                String telefone, String cep, String endereco, String usuario, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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

    public static final class Builder {
        private String nome;
        private String sobrenome;
        private String dataNascimento;
        private String email;
        private String telefone;
        private String cep;
        private String endereco;
        private String usuario;
        private String senha;

        private Builder() {
        }

        public static Builder aVoluntarioDTO() {
            return new Builder();
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
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

        public VoluntarioServicoDTO build() {
            VoluntarioServicoDTO voluntarioServicoDTO = new VoluntarioServicoDTO();
            voluntarioServicoDTO.setNome(nome);
            voluntarioServicoDTO.setSobrenome(sobrenome);
            voluntarioServicoDTO.setDataNascimento(dataNascimento);
            voluntarioServicoDTO.setEmail(email);
            voluntarioServicoDTO.setTelefone(telefone);
            voluntarioServicoDTO.setCep(cep);
            voluntarioServicoDTO.setEndereco(endereco);
            voluntarioServicoDTO.setUsuario(usuario);
            voluntarioServicoDTO.setSenha(senha);
            return voluntarioServicoDTO;
        }
    }

}
