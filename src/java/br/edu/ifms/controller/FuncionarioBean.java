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
public class FuncionarioBean implements Serializable {

    private FuncionarioMapeamento fmape;
    private FuncionarioModel fmodel;
    private FuncaoMapeamento funcaoMapeamento;
    private FuncaoModel funcaoModel;
    private String msg;
    private List<FuncionarioMapeamento> listaDeFuncionarios;

    public FuncionarioBean() {
        this.fmape = new FuncionarioMapeamento();
        this.fmodel = new FuncionarioModel();
        this.listaDeFuncionarios = new ArrayList<>();
        this.funcaoMapeamento = new FuncaoMapeamento();
        this.funcaoModel = new FuncaoModel();
    }

    public void salvar() {
        funcaoMapeamento = this.funcaoModel.buscarPorId(funcaoMapeamento.getId());
        fmape.setFuncao(funcaoMapeamento);
                
        try {
            fmodel.inserir(fmape);
            this.fmape = new FuncionarioMapeamento();
            this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDeFuncionarios = fmodel.buscarTodos();
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

}
