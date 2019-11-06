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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "maquina")
public class MaquinaMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    private String caminhoImagem;

    @ManyToOne()
    @JoinColumn(name = "idFabricante", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private FabricanteMapeamento fabricante;

    @ManyToOne()
    @JoinColumn(name = "idTipo", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private TipoMapeamento tipo;

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
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

    public FabricanteMapeamento getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteMapeamento fabricante) {
        this.fabricante = fabricante;
    }

    public TipoMapeamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMapeamento tipo) {
        this.tipo = tipo;
    }

}
