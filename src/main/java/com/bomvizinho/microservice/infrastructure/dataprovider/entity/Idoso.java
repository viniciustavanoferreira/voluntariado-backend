package com.bomvizinho.microservice.infrastructure.dataprovider.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "idoso")
public class Idoso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_idoso")
    private Long id;

    @Column(name = "condicao_saude", length = 45)
    private String condicaoSaude;

    @Column(name = "assistencia_requerida", length = 45)
    private String assistenciaRequerida;

    @Column(name = "preferencia_dia", length = 45)
    private String preferenciaDia;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_idoso", referencedColumnName = "id")
    private Usuario usuarioIdoso;

    @OneToMany(mappedBy = "idosoServico", cascade = CascadeType.ALL)
    private List<Servico> servicoIdoso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }

    public String getAssistenciaRequerida() {
        return assistenciaRequerida;
    }

    public void setAssistenciaRequerida(String assistenciaRequerida) {
        this.assistenciaRequerida = assistenciaRequerida;
    }

    public String getPreferenciaDia() {
        return preferenciaDia;
    }

    public void setPreferenciaDia(String preferenciaDia) {
        this.preferenciaDia = preferenciaDia;
    }

    public Usuario getUsuarioIdoso() {
        return usuarioIdoso;
    }

    public void setUsuarioIdoso(Usuario usuarioIdoso) {
        this.usuarioIdoso = usuarioIdoso;
    }

    public List<Servico> getServicoIdoso() {
        return servicoIdoso;
    }

    public void setServicoIdoso(List<Servico> servicoIdoso) {
        this.servicoIdoso = servicoIdoso;
    }

    public static final class Builder {
        private Long id;
        private String condicaoSaude;
        private String assistenciaRequerida;
        private String preferenciaDia;
        private Usuario usuarioIdoso;
        private List<Servico> servicoIdoso;

        private Builder() {
        }

        public static Builder anIdoso() {
            return new Builder();
        }

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCondicaoSaude(String condicaoSaude) {
            this.condicaoSaude = condicaoSaude;
            return this;
        }

        public Builder withAssistenciaRequerida(String assistenciaRequerida) {
            this.assistenciaRequerida = assistenciaRequerida;
            return this;
        }

        public Builder withPreferenciaDia(String preferenciaDia) {
            this.preferenciaDia = preferenciaDia;
            return this;
        }

        public Builder withUsuarioIdoso(Usuario usuarioIdoso) {
            this.usuarioIdoso = usuarioIdoso;
            return this;
        }

        public Builder withServicoIdoso(List<Servico> servicoIdoso) {
            this.servicoIdoso = servicoIdoso;
            return this;
        }

        public Idoso build() {
            Idoso idoso = new Idoso();
            idoso.setId(id);
            idoso.setCondicaoSaude(condicaoSaude);
            idoso.setAssistenciaRequerida(assistenciaRequerida);
            idoso.setPreferenciaDia(preferenciaDia);
            idoso.setUsuarioIdoso(usuarioIdoso);
            idoso.setServicoIdoso(servicoIdoso);
            return idoso;
        }
    }

}
