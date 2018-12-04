/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;
import br.edu.ifms.mapeamento.PecaMapeamento;
import br.edu.ifms.model.PecaModel;
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
public class PecaBean implements Serializable{
    private PecaMapeamento pecamape;
    private PecaModel pecamodel;
    private List<PecaMapeamento> listaDePecas;

    public PecaBean() {
        this.pecamape = new PecaMapeamento();
        this.pecamodel = new PecaModel();
         this.listaDePecas = new ArrayList<>();
    }
 public void salvar(){
        try{
            pecamodel.inserir(pecamape);
            this.pecamape = new PecaMapeamento();
           // this.msg = "Salvo com Sucesso!";
        }catch(Exception e){
            //this.msg ="Erro"+e.getMessage();
        }
    }
    public void buscarTodos(){
        this.listaDePecas = pecamodel.buscarTodos();
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
   }

