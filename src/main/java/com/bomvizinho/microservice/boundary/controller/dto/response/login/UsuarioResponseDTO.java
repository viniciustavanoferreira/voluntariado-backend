package com.bomvizinho.microservice.boundary.controller.dto.response.login;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Date;

public class UsuarioResponseDTO {

    private Long id;
    private String bloco;
    private Date dataNascimento;
    private String disponibilidade;
    private String email;
    private String endereco;
    private String nome;
    private String numeroApartamento;
    private String telefone;
    private String tipoPerfil;

    @JsonCreator

    public UsuarioResponseDTO(Long id, String bloco, Date dataNascimento,
                              String disponibilidade, String email,
                              String endereco, String nome, String numeroApartamento,
                              String telefone, String tipoPerfil) {
        this.id = id;
        this.bloco = bloco;
        this.dataNascimento = dataNascimento;
        this.disponibilidade = disponibilidade;
        this.email = email;
        this.endereco = endereco;
        this.nome = nome;
        this.numeroApartamento = numeroApartamento;
        this.telefone = telefone;
        this.tipoPerfil = tipoPerfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void setNumeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public static final class Builder {
        private Long id;
        private String bloco;
        private Date dataNascimento;
        private String disponibilidade;
        private String email;
        private String endereco;
        private String nome;
        private String numeroApartamento;
        private String telefone;
        private String tipoPerfil;

        private Builder() {
        }

        public static Builder anUsuarioResponseDTO() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withBloco(String bloco) {
            this.bloco = bloco;
            return this;
        }

        public Builder withDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder withDisponibilidade(String disponibilidade) {
            this.disponibilidade = disponibilidade;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder withNumeroApartamento(String numeroApartamento) {
            this.numeroApartamento = numeroApartamento;
            return this;
        }

        public Builder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder withTipoPerfil(String tipoPerfil) {
            this.tipoPerfil = tipoPerfil;
            return this;
        }

        public UsuarioResponseDTO build() {
            return new UsuarioResponseDTO(id, bloco, dataNascimento, disponibilidade, email, endereco, nome, numeroApartamento, telefone, tipoPerfil);
        }
    }

}
