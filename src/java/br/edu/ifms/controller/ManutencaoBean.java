/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FuncionarioMapeamento;
import br.edu.ifms.mapeamento.ManutencaoMapeamento;
import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.mapeamento.PrioridadeMapeamento;
import br.edu.ifms.model.FuncionarioModel;
import br.edu.ifms.model.ManutencaoModel;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.model.PrioridadeModel;
import br.edu.ifms.util.RetornoAcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Danielly
 */
@ManagedBean
@ViewScoped
public class ManutencaoBean implements Serializable {

    private ManutencaoMapeamento manutencaomape;
    private ManutencaoModel manutencaomodel;
    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private PrioridadeMapeamento prioridademape;
    private PrioridadeModel prioridademodel;
    private FuncionarioMapeamento fmape;
    private FuncionarioModel fmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<ManutencaoMapeamento> listaDeManutencoes;

    public ManutencaoBean() {
        this.manutencaomape = new ManutencaoMapeamento();
        this.manutencaomodel = new ManutencaoModel();
        this.listaDeManutencoes = new ArrayList<>();
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
        this.prioridademape = new PrioridadeMapeamento();
        this.prioridademodel = new PrioridadeModel();
        this.fmape = new FuncionarioMapeamento();
        this.fmodel = new FuncionarioModel();
    }

    public void salvar() {
        maquinaMapeamento = this.maquinaModel.buscarPorId(maquinaMapeamento.getId());
        manutencaomape.setMaquina(maquinaMapeamento);
        prioridademape = this.prioridademodel.buscarPorId(prioridademape.getId());
        manutencaomape.setPrioridade(prioridademape);
        fmape = this.fmodel.buscarPorId(fmape.getId());
        manutencaomape.setFuncionario(fmape);

        try {
            manutencaomodel.inserir(manutencaomape);
            this.manutencaomape = new ManutencaoMapeamento();
            this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDeManutencoes = manutencaomodel.buscarTodos();
    }

    public ManutencaoMapeamento getManutencaomape() {
        return manutencaomape;
    }

    public void setManutencaomape(ManutencaoMapeamento Manutencaomape) {
        this.manutencaomape = Manutencaomape;
    }

    public ManutencaoModel getManutencaomodel() {
        return manutencaomodel;
    }

    public void setManutencaomodel(ManutencaoModel Manutencaomodel) {
        this.manutencaomodel = Manutencaomodel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetornoAcao getRetornoAcao() {
        return retornoAcao;
    }

    public void setRetornoAcao(RetornoAcao retornoAcao) {
        this.retornoAcao = retornoAcao;
    }

    public List<ManutencaoMapeamento> getListaDeManutencoes() {
        return listaDeManutencoes;
    }

    public void setListaDeManutencoes(List<ManutencaoMapeamento> listaDeManutencoes) {
        this.listaDeManutencoes = listaDeManutencoes;
    }

    public MaquinaMapeamento getMaquinaMapeamento() {
        return maquinaMapeamento;
    }

    public void setMaquinaMapeamento(MaquinaMapeamento maquinaMapeamento) {
        this.maquinaMapeamento = maquinaMapeamento;
    }

    public MaquinaModel getMaquinaModel() {
        return maquinaModel;
    }

    public void setMaquinaModel(MaquinaModel maquinaModel) {
        this.maquinaModel = maquinaModel;
    }

    public PrioridadeMapeamento getPrioridademape() {
        return prioridademape;
    }

    public void setPrioridademape(PrioridadeMapeamento prioridademape) {
        this.prioridademape = prioridademape;
    }

    public PrioridadeModel getPrioridademodel() {
        return prioridademodel;
    }

    public void setPrioridademodel(PrioridadeModel prioridademodel) {
        this.prioridademodel = prioridademodel;
    }

    public FuncionarioMapeamento getFmape() {
        return fmape;
    }

    public void setFmape(FuncionarioMapeamento fmape) {
        this.fmape = fmape;
    }

    public FuncionarioModel getFmodel() {
        return fmodel;
    }

    public void setFmodel(FuncionarioModel fmodel) {
        this.fmodel = fmodel;
    }
}
