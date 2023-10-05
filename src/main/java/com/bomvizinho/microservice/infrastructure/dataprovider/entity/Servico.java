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

    @Column(name = "tipo_servico", length = 45)
    private String tipoServico;

    @Column(name = "data_hora_inicio")
    private Timestamp dataInicio;

    @Column(name = "data_hora_fim")
    private Timestamp dataFim;

    @Column(name = "ordem", length = 50)
    private String ordem;

    @Column(name = "destino", length = 100)
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

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
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

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
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

    public static final class Builder {
        private Long id;
        private String tipoServico;
        private Timestamp dataInicio;
        private Timestamp dataFim;
        private String ordem;
        private String destino;
        private String status;
        private Idoso idosoServico;
        private Voluntario voluntarioServico;

        private Builder() {
        }

        public static Builder aServico() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withTipoServico(String tipoServico) {
            this.tipoServico = tipoServico;
            return this;
        }

        public Builder withDataInicio(Timestamp dataInicio) {
            this.dataInicio = dataInicio;
            return this;
        }

        public Builder withDataFim(Timestamp dataFim) {
            this.dataFim = dataFim;
            return this;
        }

        public Builder withOrdem(String ordem) {
            this.ordem = ordem;
            return this;
        }

        public Builder withDestino(String destino) {
            this.destino = destino;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withIdosoServico(Idoso idosoServico) {
            this.idosoServico = idosoServico;
            return this;
        }

        public Builder withVoluntarioServico(Voluntario voluntarioServico) {
            this.voluntarioServico = voluntarioServico;
            return this;
        }

        public Servico build() {
            Servico servico = new Servico();
            servico.setId(id);
            servico.setTipoServico(tipoServico);
            servico.setDataInicio(dataInicio);
            servico.setDataFim(dataFim);
            servico.setOrdem(ordem);
            servico.setDestino(destino);
            servico.setStatus(status);
            servico.setIdosoServico(idosoServico);
            servico.setVoluntarioServico(voluntarioServico);
            return servico;
        }
    }

}
