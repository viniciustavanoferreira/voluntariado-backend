package com.bomvizinho.microservice.infrastructure.dataprovider.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "servico")
public class Servico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "sequenceGenerator", sequenceName = "sequence_name_usuario", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @Column(name = "id_servico")
    private Long id;

    @Column(name = "ordem", length = 45)
    private String ordem;

    @Column(name = "data_hora_inicio")
    private Timestamp dataInicio;

    @Column(name = "data_hora_fim")
    private Timestamp dataFim;

    @Column(name = "destino", length = 30)
    private String destino;

    @Column(name = "status", length = 30)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_idoso_servico", referencedColumnName = "id_idoso")
    private Idoso idosoServico;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_voluntario_servico", referencedColumnName = "id_voluntario")
    private Voluntario voluntarioServico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Idoso getIdosoServico() {
        return idosoServico;
    }

    public void setIdosoServico(Idoso idosoServico) {
        this.idosoServico = idosoServico;
    }

    public Voluntario getVoluntarioServico() {
        return voluntarioServico;
    }

    public void setVoluntarioServico(Voluntario voluntarioServico) {
        this.voluntarioServico = voluntarioServico;
    }

}
