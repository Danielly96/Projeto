/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FabricanteMapeamento;
import br.edu.ifms.model.FabricanteModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class FabricanteBean implements Serializable{
    private FabricanteMapeamento fmap;
    private FabricanteModel fmodel;

    public FabricanteBean() {
        this.fmap = new  FabricanteMapeamento() ;
        this.fmodel = new FabricanteModel();
        this.listaDeFabricantes= new ArrayList<>();
    }
    public void salvar(){
        try{
            fmodel.inserir(fmap);
            this.fmap = new FabricanteMapeamento();
           // this.msg = "Salvo com Sucesso!";
        }catch(Exception e){
            //this.msg ="Erro"+e.getMessage();
        }
    }
    public void buscarTodos(){
        this.listaDeFabricantes = fmodel.buscarTodos();
    }

    public FabricanteMapeamento getFmap() {
        return fmap;
    }

    public void setFmap(FabricanteMapeamento fmap) {
        this.fmap = fmap;
    }

    public FabricanteModel getFmodel() {
        return fmodel;
    }

    public void setFmodel(FabricanteModel fmodel) {
        this.fmodel = fmodel;
    }
     public List<FabricanteMapeamento> getListaDeFabricantes() {
        return listaDeFabricantes;
    }

    public void setListaDeFabricantes(List<FabricanteMapeamento> listaDeFabricantes) {
        this.listaDeFabricantes = listaDeFabricantes;
    }
    private List<FabricanteMapeamento> listaDeFabricantes;
     
    
}
