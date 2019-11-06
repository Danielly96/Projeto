/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.mapeamento.PecaMapeamento;
import br.edu.ifms.mapeamento.SubconjuntoMapeamento;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.model.PecaModel;
import br.edu.ifms.model.SubconjuntoModel;
import br.edu.ifms.util.RetornoAcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Danielly
 */
@ManagedBean
@SessionScoped
public class SubconjuntoBean implements Serializable {

    private SubconjuntoMapeamento subconjuntomape;
    private SubconjuntoModel subconjuntomodel;
    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private PecaMapeamento pecaMapeamento;
    private PecaModel pecaModel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<SubconjuntoMapeamento> listaDeSubconjuntos;

    public SubconjuntoBean() {
        this.subconjuntomape = new SubconjuntoMapeamento();
        this.subconjuntomodel = new SubconjuntoModel();
        this.listaDeSubconjuntos = new ArrayList<>();
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
        this.pecaMapeamento = new PecaMapeamento();
        this.pecaModel = new PecaModel();
    }

    public void inicializa() {
        this.subconjuntomape = null;
        this.maquinaMapeamento = null;
        this.pecaMapeamento = null;
        this.retornoAcao = null;
        this.subconjuntomape = new SubconjuntoMapeamento();
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.pecaMapeamento = new PecaMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        maquinaMapeamento = this.maquinaModel.buscarPorId(maquinaMapeamento.getId());
        subconjuntomape.setMaquina(maquinaMapeamento);
        pecaMapeamento = this.pecaModel.buscarPorId(pecaMapeamento.getId());
        subconjuntomape.setPeca(pecaMapeamento);
        try {
            subconjuntomodel.inserir(subconjuntomape);
            this.subconjuntomape = new SubconjuntoMapeamento();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public String editar(Long subconjuntoID) {
        this.subconjuntomape = subconjuntomodel.buscarPorId(subconjuntoID);

        return "editarSubconjunto.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        maquinaMapeamento = this.maquinaModel.buscarPorId(maquinaMapeamento.getId());
        subconjuntomape.setMaquina(maquinaMapeamento);
        pecaMapeamento = this.pecaModel.buscarPorId(pecaMapeamento.getId());
        subconjuntomape.setPeca(pecaMapeamento);
        try {
            subconjuntomodel.update(subconjuntomape);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarSubconjunto.xhtml?faces-redirect=true";
    }

    public void buscarTodos() {
        inicializa();
        this.listaDeSubconjuntos = subconjuntomodel.buscarTodos();
    }

    public void excluir(Long subconjuntoID) {
        this.subconjuntomodel.excluir(subconjuntomodel.buscarPorId(subconjuntoID));

    }

    public SubconjuntoMapeamento getSubconjuntomape() {
        return subconjuntomape;
    }

    public void setSubconjuntomape(SubconjuntoMapeamento subconjuntomape) {
        this.subconjuntomape = subconjuntomape;
    }

    public SubconjuntoModel getSubconjuntomodel() {
        return subconjuntomodel;
    }

    public void setSubconjuntomodel(SubconjuntoModel subconjuntomodel) {
        this.subconjuntomodel = subconjuntomodel;
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

    public List<SubconjuntoMapeamento> getListaDeSubconjuntos() {
        return listaDeSubconjuntos;
    }

    public void setListaDeSubconjuntos(List<SubconjuntoMapeamento> listaDeSubconjuntos) {
        this.listaDeSubconjuntos = listaDeSubconjuntos;
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

    public PecaMapeamento getPecaMapeamento() {
        return pecaMapeamento;
    }

    public void setPecaMapeamento(PecaMapeamento pecaMapeamento) {
        this.pecaMapeamento = pecaMapeamento;
    }

    public PecaModel getPecaModel() {
        return pecaModel;
    }

    public void setPecaModel(PecaModel pecaModel) {
        this.pecaModel = pecaModel;
    }
}
