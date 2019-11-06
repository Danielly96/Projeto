/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FuncaoMapeamento;
import br.edu.ifms.model.FuncaoModel;
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
public class FuncaoBean implements Serializable {

    private FuncaoMapeamento funcaomape;
    private FuncaoModel funcaomodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<FuncaoMapeamento> listaDeFuncoes;

    public FuncaoBean() {
        this.funcaomape = new FuncaoMapeamento();
        this.funcaomodel = new FuncaoModel();
        this.listaDeFuncoes = new ArrayList<>();
        this.msg = "";
    }

    public void inicializa() {
        this.funcaomape = null;
        this.retornoAcao = null;
        this.funcaomape = new FuncaoMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        try {
            funcaomodel.inserir(funcaomape);
            this.funcaomape = new FuncaoMapeamento();
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
        this.listaDeFuncoes = funcaomodel.buscarTodos();
    }

    public String editar(Long funcaoID) {
        this.funcaomape = funcaomodel.buscarPorId(funcaoID);

        return "editarFuncao.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        try {
            funcaomodel.update(funcaomape);
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarFuncao.xhtml?faces-redirect=true";
    }

    public void excluir(Long funcaoID) {
        this.funcaomodel.excluir(funcaomodel.buscarPorId(funcaoID));
    }

    public FuncaoMapeamento getFuncaomape() {
        return funcaomape;
    }

    public void setFuncaomape(FuncaoMapeamento funcaomape) {
        this.funcaomape = funcaomape;
    }

    public FuncaoModel getFuncaomodel() {
        return funcaomodel;
    }

    public void setFuncaomodel(FuncaoModel funcaomodel) {
        this.funcaomodel = funcaomodel;
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

    public List<FuncaoMapeamento> getListaDeFuncoes() {
        return listaDeFuncoes;
    }

    public void setListaDeFuncoes(List<FuncaoMapeamento> listaDeFuncoes) {
        this.listaDeFuncoes = listaDeFuncoes;
    }
}
