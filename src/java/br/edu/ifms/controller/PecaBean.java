/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.PecaMapeamento;
import br.edu.ifms.model.PecaModel;
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
public class PecaBean implements Serializable {

    private PecaMapeamento pecamape;
    private PecaModel pecamodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<PecaMapeamento> listaDePecas;

    public PecaBean() {
        this.pecamape = new PecaMapeamento();
        this.pecamodel = new PecaModel();
        this.listaDePecas = new ArrayList<>();
        this.msg = "";
    }

    public void inicializa() {
        this.pecamape = null;
        this.retornoAcao = null;
        this.pecamape = new PecaMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        try {
            pecamodel.inserir(pecamape);
            this.pecamape = new PecaMapeamento();
          FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public String editar(Long pecaID) {
        this.pecamape = pecamodel.buscarPorId(pecaID);

        return "editarPeca.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        try {
            pecamodel.update(pecamape);
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }

        return "cadastrarPeca.xhtml?faces-redirect=true";
    }

    public void buscarTodos() {
        inicializa();
        this.listaDePecas = pecamodel.buscarTodos();
    }

    public void excluir(Long pecaID) {
        this.pecamodel.excluir(pecamodel.buscarPorId(pecaID));
    }

    public PecaMapeamento getPecamape() {
        return pecamape;
    }

    public void setPecamape(PecaMapeamento pecamape) {
        this.pecamape = pecamape;
    }

    public PecaModel getPecamodel() {
        return pecamodel;
    }

    public void setPecamodel(PecaModel pecamodel) {
        this.pecamodel = pecamodel;
    }

    public List<PecaMapeamento> getListaDePecas() {
        return listaDePecas;
    }

    public void setListaDePecas(List<PecaMapeamento> listaDePecas) {
        this.listaDePecas = listaDePecas;
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
}
