/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import java.util.Collection;
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
@Inheritance(strategy=InheritanceType.JOINED)
@Table (name ="maquina")
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
    @OneToMany(mappedBy="maquina", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Collection manutencao;
   // OneToMany(mappedBy="maquina", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Collection subconjunto;

    public MaquinaMapeamento(){}
    
    public MaquinaMapeamento(long id, String descricao, long idTipoMapeamento, FabricanteMapeamento fabricante) {
        this.id = id;
        this.descricao = descricao;
        this.idTipoMapeamento = idTipoMapeamento;
        this.fabricante = fabricante;
    }
      public Collection getManutencao() {
        return manutencao;
    }
      public Collection getSubconjunto() {
        return subconjunto;
    }

    public void setSubconjunto(Collection subconjunto) {
        this.subconjunto = subconjunto;
    }
  
    public void setManutencao(Collection manutencao) {
        this.manutencao = manutencao;
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
