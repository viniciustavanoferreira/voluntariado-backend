package com.bomvizinho.microservice.boundary.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.sql.Date;

public class UsuarioRequestDTO {

    private String nome;
    private String usuario;
    private String senha;
    private String email;
    private String cep;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String bloco;
    private String numeroAp;
    private String telefone;
    private Date dataNascimento;
    private String perfil;
    private String disponibilidade;

    public UsuarioRequestDTO() {
    }

    @JsonCreator
    public UsuarioRequestDTO(String nome, String usuario,
                             String senha, String email,
                             String cep, String endereco,
                             String bairro, String cidade,
                             String estado, String complemento,
                             String bloco, String numeroAp,
                             String telefone, Date dataNascimento,
                             String perfil, String disponibilidade) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.email = email;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.bloco = bloco;
        this.numeroAp = numeroAp;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.perfil = perfil;
        this.disponibilidade = disponibilidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getNumeroAp() {
        return numeroAp;
    }

    public void setNumeroAp(String numeroAp) {
        this.numeroAp = numeroAp;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public static final class Builder {
        private String nome;
        private String usuario;
        private String senha;
        private String email;
        private String cep;
        private String endereco;
        private String bairro;
        private String cidade;
        private String estado;
        private String complemento;
        private String bloco;
        private String numeroAp;
        private String telefone;
        private Date dataNascimento;
        private String perfil;
        private String disponibilidade;

        private Builder() {
        }

        public static Builder anUsuarioRequestDTO() {
            return new Builder();
        }

        public Builder withNome(String nome) {
            this.nome = nome;
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

        public Builder withEmail(String email) {
            this.email = email;
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

        public Builder withBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public Builder withCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public Builder withEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder withComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public Builder withBloco(String bloco) {
            this.bloco = bloco;
            return this;
        }

        public Builder withNumeroAp(String numeroAp) {
            this.numeroAp = numeroAp;
            return this;
        }

        public Builder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder withDataNascimento(Date dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }

        public Builder withPerfil(String perfil) {
            this.perfil = perfil;
            return this;
        }

        public Builder withDisponibilidade(String disponibilidade) {
            this.disponibilidade = disponibilidade;
            return this;
        }

        public UsuarioRequestDTO build() {
            UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO();
            usuarioRequestDTO.setNome(nome);
            usuarioRequestDTO.setUsuario(usuario);
            usuarioRequestDTO.setSenha(senha);
            usuarioRequestDTO.setEmail(email);
            usuarioRequestDTO.setCep(cep);
            usuarioRequestDTO.setEndereco(endereco);
            usuarioRequestDTO.setBairro(bairro);
            usuarioRequestDTO.setCidade(cidade);
            usuarioRequestDTO.setEstado(estado);
            usuarioRequestDTO.setComplemento(complemento);
            usuarioRequestDTO.setBloco(bloco);
            usuarioRequestDTO.setNumeroAp(numeroAp);
            usuarioRequestDTO.setTelefone(telefone);
            usuarioRequestDTO.setDataNascimento(dataNascimento);
            usuarioRequestDTO.setPerfil(perfil);
            usuarioRequestDTO.setDisponibilidade(disponibilidade);
            return usuarioRequestDTO;
        }
    }

}
