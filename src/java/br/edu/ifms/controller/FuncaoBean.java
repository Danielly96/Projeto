/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FuncaoMapeamento;
import br.edu.ifms.model.FuncaoModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class FuncaoBean implements Serializable{
    private FuncaoMapeamento funcaomape;
    private FuncaoModel funcaomodel;

    public FuncaoBean() {
        this.funcaomape = new FuncaoMapeamento();
        this.funcaomodel = new FuncaoModel();
        this.listaDeFuncoes = new ArrayList<>();
    }
      public void salvar(){
        try{
            funcaomodel.inserir(funcaomape);
            this.funcaomape = new FuncaoMapeamento();
           // this.msg = "Salvo com Sucesso!";
        }catch(Exception e){
            //this.msg ="Erro"+e.getMessage();
        }
    }
    public void buscarTodos(){
        this.listaDeFuncoes = funcaomodel.buscarTodos();
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
     public List<FuncaoMapeamento> getListaDeFuncoes() {
        return listaDeFuncoes;
    }

    public void setListaDeFuncoes(List<FuncaoMapeamento> listaDeFuncoes) {
        this.listaDeFuncoes = listaDeFuncoes;
    }
    private List<FuncaoMapeamento> listaDeFuncoes;
     
}
