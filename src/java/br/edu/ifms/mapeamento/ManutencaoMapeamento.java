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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
    @ManyToOne
    private MaquinaMapeamento maquinaId;
    @ManyToOne
    private PrioridadeMapeamento prioridadeId;
    @ManyToOne
    private FuncionarioMapeamento funcionarioQueIdentificouId;
    @ManyToOne
    private FuncionarioMapeamento funcionarioQueFezManutencaoId;
    private String descricaoDoProblema;
    private String descricaoDaSolucao;
    private Date dataQueIdentificou;
    private Date dataManutencaoMarcada;
    private Date dataManutencaoRealizada;
    private boolean emManutencao;

    public ManutencaoMapeamento(long id, MaquinaMapeamento maquinaId, PrioridadeMapeamento prioridadeId, FuncionarioMapeamento funcionarioQueIdentificouId, FuncionarioMapeamento funcionarioQueFezManutencaoId, String descricaoDoProblema, String descricaoDaSolucao, Date dataQueIdentificou, Date dataManutencaoMarcada, Date dataManutencaoRealizada, boolean emManutencao) {
        this.id = id;
        this.maquinaId = maquinaId;
        this.prioridadeId = prioridadeId;
        this.funcionarioQueIdentificouId = funcionarioQueIdentificouId;
        this.funcionarioQueFezManutencaoId = funcionarioQueFezManutencaoId;
        this.descricaoDoProblema = descricaoDoProblema;
        this.descricaoDaSolucao = descricaoDaSolucao;
        this.dataQueIdentificou = dataQueIdentificou;
        this.dataManutencaoMarcada = dataManutencaoMarcada;
        this.dataManutencaoRealizada = dataManutencaoRealizada;
        this.emManutencao = emManutencao;
    }
    
    
    public ManutencaoMapeamento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MaquinaMapeamento getMaquinaId() {
        return maquinaId;
    }

    public void setMaquinaId(MaquinaMapeamento maquinaId) {
        this.maquinaId = maquinaId;
    }

    public PrioridadeMapeamento getPrioridadeId() {
        return prioridadeId;
    }

    public void setPrioridadeId(PrioridadeMapeamento prioridadeId) {
        this.prioridadeId = prioridadeId;
    }

    public FuncionarioMapeamento getFuncionarioQueIdentificouId() {
        return funcionarioQueIdentificouId;
    }

    public void setFuncionarioQueIdentificouId(FuncionarioMapeamento funcionarioQueIdentificouId) {
        this.funcionarioQueIdentificouId = funcionarioQueIdentificouId;
    }

    public FuncionarioMapeamento getFuncionarioQueFezManutencaoId() {
        return funcionarioQueFezManutencaoId;
    }

    public void setFuncionarioQueFezManutencaoId(FuncionarioMapeamento funcionarioQueFezManutencaoId) {
        this.funcionarioQueFezManutencaoId = funcionarioQueFezManutencaoId;
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
}
