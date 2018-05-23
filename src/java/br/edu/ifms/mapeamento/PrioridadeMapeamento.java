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
import javax.persistence.Table;

/**
 *
 * @author Danielly
 */
@Entity
@Table (name ="prioridade")
public class PrioridadeMapeamento implements Serializable{
    @Id
    @GeneratedValue
    private long id; 
    private String descricao;
    private String qntdias;

    public PrioridadeMapeamento(long id, String descricao, String qntdias) {
        this.id = id;
        this.descricao = descricao;
        this.qntdias = qntdias;
    }

    public PrioridadeMapeamento() {
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

    public String getQntdias() {
        return qntdias;
    }

    public void setQntdias(String qntdias) {
        this.qntdias = qntdias;
    }
    
    
}
