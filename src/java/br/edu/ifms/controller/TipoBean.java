/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.TipoMapeamento;
import br.edu.ifms.model.TipoModel;
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
public class TipoBean implements Serializable {

    private TipoMapeamento tmap;
    private TipoModel tmodel;
    private List<TipoMapeamento> listaDeTipos;

    public TipoBean() {
        this.tmap = new TipoMapeamento();
        this.tmodel = new TipoModel();
        this.listaDeTipos = new ArrayList<>();
    }

    public void salvar() {
        try {
          tmodel.inserir(tmap);
            this.tmap = new TipoMapeamento();
            // this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            //this.msg ="Erro"+e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDeTipos = tmodel.buscarTodos();
    }

    public TipoMapeamento getTmap() {
        return tmap;
    }

    public void setTmap(TipoMapeamento tmap) {
        this.tmap = tmap;
    }

    public TipoModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(TipoModel tmodel) {
        this.tmodel = tmodel;
    }

    public List<TipoMapeamento> getListaDeTipos() {
        return listaDeTipos;
    }

    public void setListaDeFuncoes(List<TipoMapeamento> listaDeTipos) {
        this.listaDeTipos = listaDeTipos;
    }

}
