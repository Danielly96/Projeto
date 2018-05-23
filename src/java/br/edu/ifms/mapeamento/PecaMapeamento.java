/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "peca")
public class PecaMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    @ManyToOne
    private SubconjuntoMapeamento subconjunto;

    public PecaMapeamento(long id, String descricao, SubconjuntoMapeamento subconjunto) {
        this.id = id;
        this.descricao = descricao;
        this.subconjunto = subconjunto;
    }

    public PecaMapeamento() {
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

    public SubconjuntoMapeamento getSubconjunto() {
        return subconjunto;
    }

    public void setSubconjunto(SubconjuntoMapeamento subconjunto) {
        this.subconjunto = subconjunto;
    }

}
