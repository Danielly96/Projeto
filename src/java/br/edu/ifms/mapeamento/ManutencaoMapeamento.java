/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "manutencao")
public class ManutencaoMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricaoDoProblema;
    private String descricaoDaSolucao;
    private String funcionarioDetectouProblema;
    private String funcionarioRealizouManutencao;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataQueIdentificou;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataManutencaoMarcada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataManutencaoRealizada;
    private boolean emManutencao;
    @ManyToOne()
    @JoinColumn(name = "idMaquina", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private MaquinaMapeamento maquina;
    @ManyToOne
    @JoinColumn(name = "idPrioridade", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private PrioridadeMapeamento prioridade;
    @ManyToOne
    @JoinColumn(name = "idFuncionario", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private FuncionarioMapeamento funcionario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoDoProblema() {
        return descricaoDoProblema;
    }

    public void setDescricaoDoProblema(String descricaoDoProblema) {
        this.descricaoDoProblema = descricaoDoProblema;
    }

    public String getDescricaoDaSolucao() {
        return descricaoDaSolucao;
    }

    public void setDescricaoDaSolucao(String descricaoDaSolucao) {
        this.descricaoDaSolucao = descricaoDaSolucao;
    }

    public Date getDataQueIdentificou() {
        return dataQueIdentificou;
    }

    public void setDataQueIdentificou(Date dataQueIdentificou) {
        this.dataQueIdentificou = dataQueIdentificou;
    }

    public Date getDataManutencaoMarcada() {
        return dataManutencaoMarcada;
    }

    public void setDataManutencaoMarcada(Date dataManutencaoMarcada) {
        this.dataManutencaoMarcada = dataManutencaoMarcada;
    }

    public Date getDataManutencaoRealizada() {
        return dataManutencaoRealizada;
    }

    public void setDataManutencaoRealizada(Date dataManutencaoRealizada) {
        this.dataManutencaoRealizada = dataManutencaoRealizada;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }

    public void setEmManutencao(boolean emManutencao) {
        this.emManutencao = emManutencao;
    }

    public MaquinaMapeamento getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinaMapeamento maquina) {
        this.maquina = maquina;
    }

    public PrioridadeMapeamento getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(PrioridadeMapeamento prioridade) {
        this.prioridade = prioridade;
    }

    public FuncionarioMapeamento getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioMapeamento funcionario) {
        this.funcionario = funcionario;
    }

    public String getFuncionarioDetectouProblema() {
        return funcionarioDetectouProblema;
    }

    public void setFuncionarioDetectouProblema(String funcionarioDetectouProblema) {
        this.funcionarioDetectouProblema = funcionarioDetectouProblema;
    }

    public String getFuncionarioRealizouManutencao() {
        return funcionarioRealizouManutencao;
    }

    public void setFuncionarioRealizouManutencao(String funcionarioRealizouManutencao) {
        this.funcionarioRealizouManutencao = funcionarioRealizouManutencao;
    }

}
