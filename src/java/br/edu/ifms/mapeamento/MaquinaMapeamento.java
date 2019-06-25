/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Danielly
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "maquina")
public class MaquinaMapeamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private long idTipoMapeamento;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private FabricanteMapeamento fabricante;
    @ManyToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private TipoMapeamento tipo;
    @OneToMany(mappedBy = "maquina", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<ManutencaoMapeamento> manutencao;
    // OneToMany(mappedBy="maquina", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<SubconjuntoMapeamento> subconjunto;

    
    public List<ManutencaoMapeamento> getManutencao() {
        return manutencao;
    }

    public void setManutencao(List<ManutencaoMapeamento> manutencao) {
        this.manutencao = manutencao;
    }

    public List<SubconjuntoMapeamento> getSubconjunto() {
        return subconjunto;
    }

    public void setSubconjunto(List<SubconjuntoMapeamento> subconjunto) {
        this.subconjunto = subconjunto;
    }

    public TipoMapeamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoMapeamento tipo) {
        this.tipo = tipo;
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

    public long getIdTipoMapeamento() {
        return idTipoMapeamento;
    }

    public void setIdTipoMapeamento(long idTipoMapeamento) {
        this.idTipoMapeamento = idTipoMapeamento;
    }

    public FabricanteMapeamento getFabricante() {
        return fabricante;
    }

    public void setFabricante(FabricanteMapeamento fabricante) {
        this.fabricante = fabricante;
    }

}
