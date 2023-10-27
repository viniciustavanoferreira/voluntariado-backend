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
    @Column(name = "id")
    private Long id;

    @Column(name = "id_usuario", length = 50)
    private String idUsuario;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "senha", length = 30)
    private String senha;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "endereco", length = 100)
    private String endereco;

    @Column(name = "bairro", length = 100)
    private String bairro;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @Column(name = "estado", length = 100)
    private String estado;

    @Column(name = "complemento", length = 100)
    private String complemento;

    @Column(name = "bloco", length = 10)
    private String bloco;

    @Column(name = "numero_ap", length = 10)
    private String numeroAp;

    @Column(name = "telefone", length = 20)
    private String telefone;

    @Column(name = "nascimento")
    private Date dataNascimento;

    @Column(name = "perfil", length = 50)
    private String perfil;

    @Column(name = "disponibilidade", length = 45)
    private String disponibilidade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
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
        private Long id;
        private String idUsuario;
        private String nome;
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

        public static Builder anUsuario() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withIdUsuario(String idUsuario) {
            this.idUsuario = idUsuario;
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

        public Usuario build() {
            Usuario usuario = new Usuario();
            usuario.setId(id);
            usuario.setIdUsuario(idUsuario);
            usuario.setNome(nome);
            usuario.setSenha(senha);
            usuario.setEmail(email);
            usuario.setCep(cep);
            usuario.setEndereco(endereco);
            usuario.setBairro(bairro);
            usuario.setCidade(cidade);
            usuario.setEstado(estado);
            usuario.setComplemento(complemento);
            usuario.setBloco(bloco);
            usuario.setNumeroAp(numeroAp);
            usuario.setTelefone(telefone);
            usuario.setDataNascimento(dataNascimento);
            usuario.setPerfil(perfil);
            usuario.setDisponibilidade(disponibilidade);
            return usuario;
        }
    }

}
