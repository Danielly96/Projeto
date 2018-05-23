/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.ManutencaoMapeamento;
import br.edu.ifms.model.ManutencaoModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class ManutencaoBean implements Serializable{
    private ManutencaoMapeamento manutencaomape;
    private ManutencaoModel manutencaomodel;

    public ManutencaoBean() {
        this.manutencaomape = new ManutencaoMapeamento();
        this.manutencaomodel = new ManutencaoModel();
         this.listaDeManutencoes = new ArrayList<>();
    }
      public void salvar(){
        try{
            manutencaomodel.inserir(manutencaomape);
            this.manutencaomape = new ManutencaoMapeamento();
           // this.msg = "Salvo com Sucesso!";
        }catch(Exception e){
            //this.msg ="Erro"+e.getMessage();
        }
    } 
       public void buscarTodos(){
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
   public List<ManutencaoMapeamento> getListaDeManutencoes() {
        return listaDeManutencoes;
    }

    public void setListaDeManutencoes(List<ManutencaoMapeamento> listaDeManutencoes) {
        this.listaDeManutencoes = listaDeManutencoes;
    }
    private List<ManutencaoMapeamento> listaDeManutencoes;
          
}
