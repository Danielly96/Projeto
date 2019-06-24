/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "funcionario")
public class FuncionarioMapeamento implements Serializable {
    @Id
    @GeneratedValue
    private long matricula;
    private String nome;
    
    @ManyToOne()
    @JoinColumn(name="idFuncao", insertable=true, updatable=true)
    @Fetch(FetchMode.JOIN)
    private FuncaoMapeamento funcao;
    
    //@OneToMany(mappedBy="funcionario", fetch = FetchType.LAZY)
    //@Cascade(CascadeType.ALL)
    //private Collection manutencao;
    
    /*public Collection getManutencao() {
        return manutencao;
    }

    public void setManutencao(Collection manutencao) {
        this.manutencao = manutencao;
    }*/
     
    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public FuncaoMapeamento getFuncao() {
        return funcao;
    }

    public void setFuncao(FuncaoMapeamento funcao) {
        this.funcao = funcao;
    }
    
  }
