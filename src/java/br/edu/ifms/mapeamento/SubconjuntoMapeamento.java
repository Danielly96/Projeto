/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "subconjunto")
public class SubconjuntoMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "idMaquina", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private MaquinaMapeamento maquina;
    @ManyToOne()
    @JoinColumn(name = "idPeca", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private PecaMapeamento peca;

    public SubconjuntoMapeamento(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;

    }

    public SubconjuntoMapeamento() {
    }
    
    public PecaMapeamento getPeca() {
        return peca;
    }

    public void setPeca(PecaMapeamento peca) {
        this.peca = peca;
    }

    public MaquinaMapeamento getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinaMapeamento maquina) {
        this.maquina = maquina;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
