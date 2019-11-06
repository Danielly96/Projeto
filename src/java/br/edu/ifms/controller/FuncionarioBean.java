/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FuncaoMapeamento;
import br.edu.ifms.mapeamento.FuncionarioMapeamento;
import br.edu.ifms.model.FuncaoModel;
import br.edu.ifms.model.FuncionarioModel;
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
public class FuncionarioBean implements Serializable {

    private FuncionarioMapeamento fmape;
    private FuncionarioModel fmodel;
    private FuncaoMapeamento funcaoMapeamento;
    private FuncaoModel funcaoModel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<FuncionarioMapeamento> listaDeFuncionarios;

    public FuncionarioBean() {
        this.fmape = new FuncionarioMapeamento();
        this.fmodel = new FuncionarioModel();
        this.listaDeFuncionarios = new ArrayList<>();
        this.funcaoMapeamento = new FuncaoMapeamento();
        this.funcaoModel = new FuncaoModel();
        this.msg = "";
    }

    public void inicializa() {
        this.fmape = null;
        this.funcaoMapeamento = null;
        this.retornoAcao = null;
        this.fmape = new FuncionarioMapeamento();
        this.funcaoMapeamento = new FuncaoMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        funcaoMapeamento = this.funcaoModel.buscarPorId(funcaoMapeamento.getId());
        fmape.setFuncao(funcaoMapeamento);
        try {
            fmodel.inserir(fmape);
            this.fmape = new FuncionarioMapeamento();
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public String editar(Long funcionarioID) {
        this.fmape = fmodel.buscarPorId(funcionarioID);

        return "editarFuncionario.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        funcaoMapeamento = this.funcaoModel.buscarPorId(funcaoMapeamento.getId());
        fmape.setFuncao(funcaoMapeamento);
        try {
            fmodel.update(fmape);
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarFuncionario.xhtml?faces-redirect=true";
    }

    public void buscarTodos() {
        inicializa();
        this.listaDeFuncionarios = fmodel.buscarTodos();
    }

    public void excluir(Long funcionarioID) {
        this.fmodel.excluir(fmodel.buscarPorId(funcionarioID));
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<FuncionarioMapeamento> getListaDeFuncionarios() {
        return listaDeFuncionarios;
    }

    public void setListaDeFuncionarios(List<FuncionarioMapeamento> listaDeFuncionarios) {
        this.listaDeFuncionarios = listaDeFuncionarios;
    }

    public FuncaoMapeamento getFuncaoMapeamento() {
        return funcaoMapeamento;
    }

    public void setFuncaoMapeamento(FuncaoMapeamento funcaoMapeamento) {
        this.funcaoMapeamento = funcaoMapeamento;
    }

    public FuncaoModel getFuncaoModel() {
        return funcaoModel;
    }

    public void setFuncaoModel(FuncaoModel funcaoModel) {
        this.funcaoModel = funcaoModel;
    }

    public RetornoAcao getRetornoAcao() {
        return retornoAcao;
    }

    public void setRetornoAcao(RetornoAcao retornoAcao) {
        this.retornoAcao = retornoAcao;
    }
}
