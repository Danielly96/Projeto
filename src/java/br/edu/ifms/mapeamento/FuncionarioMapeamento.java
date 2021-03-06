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
    private long id;
    private long matricula;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "idFuncao", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private FuncaoMapeamento funcao;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
