/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.PrioridadeMapeamento;
import br.edu.ifms.model.PrioridadeModel;
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
public class PrioridadeBean implements Serializable {

    private PrioridadeMapeamento prioridademape;
    private PrioridadeModel prioridademodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<PrioridadeMapeamento> listaDePrioridades;

    public PrioridadeBean() {
        this.prioridademape = new PrioridadeMapeamento();
        this.prioridademodel = new PrioridadeModel();
        this.listaDePrioridades = new ArrayList<>();
        this.msg = "";
    }

    public void inicializa() {
        this.prioridademape = null;
        this.retornoAcao = null;
        this.prioridademape = new PrioridadeMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        try {
            prioridademodel.inserir(prioridademape);
            this.prioridademape = new PrioridadeMapeamento();
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
        inicializa();
        this.listaDePrioridades = prioridademodel.buscarTodos();
    }

    public String editar(Long prioridadeID) {
        this.prioridademape = prioridademodel.buscarPorId(prioridadeID);

        return "editarPrioridade.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        try {
            prioridademodel.update(prioridademape);
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarPrioridade.xhtml?faces-redirect=true";
    }

    public void excluir(Long prioridadeID) {
        this.prioridademodel.excluir(prioridademodel.buscarPorId(prioridadeID));
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

    public List<PrioridadeMapeamento> getListaDePrioridades() {
        return listaDePrioridades;
    }

    public void setListaDePrioridades(List<PrioridadeMapeamento> listaDePrioridades) {
        this.listaDePrioridades = listaDePrioridades;
    }

}
