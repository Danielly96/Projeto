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
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(org.hibernate.annotations.FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
     private MaquinaMapeamento maquina;
    List<PecaMapeamento> peca;

    public List<PecaMapeamento> getPeca() {
        return peca;
    }

    public void setPeca(List<PecaMapeamento> peca) {
        this.peca = peca;
    }
        public SubconjuntoMapeamento(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
  
    }

    public SubconjuntoMapeamento() {
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
