package com.bomvizinho.microservice.infrastructure.dataprovider.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "voluntario")
public class Voluntario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sequenceGenenator", sequenceName = "sequence_name_voluntario", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @Column(name = "id_voluntario")
    private Long id;

    @Column(name = "preferencia", length = 45)
    private String preferencia;

    @Column(name = "habilidade", length = 45)
    private String habilidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_idoso", referencedColumnName = "id_usuario")
    private Usuario usuarioVoluntario;

    @OneToMany(mappedBy = "voluntarioServico", cascade = CascadeType.ALL)
    private List<Servico> servicoVoluntario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(String preferencia) {
        this.preferencia = preferencia;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(String habilidade) {
        this.habilidade = habilidade;
    }

    public Usuario getUsuarioVoluntario() {
        return usuarioVoluntario;
    }

    public void setUsuarioVoluntario(Usuario usuarioVoluntario) {
        this.usuarioVoluntario = usuarioVoluntario;
    }

    public List<Servico> getServicoVoluntario() {
        return servicoVoluntario;
    }

    public void setServicoVoluntario(List<Servico> servicoVoluntario) {
        this.servicoVoluntario = servicoVoluntario;
    }

}
