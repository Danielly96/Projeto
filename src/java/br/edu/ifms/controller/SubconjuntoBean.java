/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.SubconjuntoMapeamento;
import br.edu.ifms.model.SubconjuntoModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class SubconjuntoBean implements Serializable{
    private SubconjuntoMapeamento subconjuntomape;
    private SubconjuntoModel subconjuntomodel;

    public SubconjuntoBean() {
        this.subconjuntomape = new SubconjuntoMapeamento();
        this.subconjuntomodel =new SubconjuntoModel();
          this.listaDeSubconjuntos = new ArrayList<>();
    }
      public void salvar(){
        try{
            subconjuntomodel.inserir(subconjuntomape);
            this.subconjuntomape = new SubconjuntoMapeamento();
           // this.msg = "Salvo com Sucesso!";
        }catch(Exception e){
            //this.msg ="Erro"+e.getMessage();
        }
    }
    public void buscarTodos(){
        this.listaDeSubconjuntos = subconjuntomodel.buscarTodos();
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
 public List<SubconjuntoMapeamento> getListaDeSubconjuntos() {
        return listaDeSubconjuntos;
    }

    public void setListaDeSubconjuntos(List<SubconjuntoMapeamento> listaDeSubconjuntos) {
        this.listaDeSubconjuntos= listaDeSubconjuntos;
    }
    private List<SubconjuntoMapeamento> listaDeSubconjuntos;
}
