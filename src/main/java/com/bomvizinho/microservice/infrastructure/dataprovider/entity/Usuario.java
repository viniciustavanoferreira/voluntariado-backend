package com.bomvizinho.microservice.infrastructure.dataprovider.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "usuario")
public class Usuario  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "senha", length = 30)
    private String senha;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "nascimento")
    private Date dataNascimento;

    @Column(name = "bloco", length = 10)
    private String bloco;

    @Column(name = "numero_ap", length = 10)
    private String numeroAp;

    @Column(name = "tipo_perfil", length = 50)
    private String tipoPerfil;

    @Column(name = "disponibilidade", length = 45)
    private String disponibilidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public static final class Builder {
        private Long id;
        private String nome;
        private String senha;
        private String email;
        private String endereco;
        private String telefone;
        private Date dataNascimento;
        private String bloco;
        private String numeroAp;
        private String tipoPerfil;
        private String disponibilidade;

        private Builder() {
        }

        public static Builder anUsuario() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withNome(String nome) {
            this.nome = nome;
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

        public Builder withEndereco(String endereco) {
            this.endereco = endereco;
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

        public Builder withBloco(String bloco) {
            this.bloco = bloco;
            return this;
        }

        public Builder withNumeroAp(String numeroAp) {
            this.numeroAp = numeroAp;
            return this;
        }

        public Builder withTipoPerfil(String tipoPerfil) {
            this.tipoPerfil = tipoPerfil;
            return this;
        }

        public Builder withDisponibilidade(String disponibilidade) {
            this.disponibilidade = disponibilidade;
            return this;
        }

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            usuario.setEndereco(endereco);
            usuario.setTelefone(telefone);
            usuario.setDataNascimento(dataNascimento);
            usuario.setBloco(bloco);
            usuario.setNumeroAp(numeroAp);
            usuario.setTipoPerfil(tipoPerfil);
            usuario.setDisponibilidade(disponibilidade);
            return usuario;
        }
    }

}
