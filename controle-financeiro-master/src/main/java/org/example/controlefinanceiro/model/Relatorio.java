package org.example.controlefinanceiro.model;

import jakarta.persistence.*;
import org.example.controlefinanceiro.model.enums.TipoRelatorio;
import java.util.Date;

@Entity
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoRelatorio tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataGeracao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoRelatorio getTipo() {
        return tipo;
    }

    public void setTipo(TipoRelatorio tipo) {
        this.tipo = tipo;
    }

    public Date getDataGeracao() {
        return dataGeracao;
    }

    public void setDataGeracao(Date dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}