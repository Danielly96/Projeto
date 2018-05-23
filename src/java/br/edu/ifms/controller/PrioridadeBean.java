/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;
import br.edu.ifms.mapeamento.PrioridadeMapeamento;
import br.edu.ifms.model.PrioridadeModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class PrioridadeBean implements Serializable {

    private PrioridadeMapeamento prioridademape;
    private PrioridadeModel prioridademodel;

    public PrioridadeBean() {
        this.prioridademape = new PrioridadeMapeamento();
        this.prioridademodel = new PrioridadeModel();
        this.listaDePrioridades = new ArrayList<>();
    }

    public void salvar() {
        try {
            prioridademodel.inserir(prioridademape);
            this.prioridademape = new PrioridadeMapeamento();
            // this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            //this.msg ="Erro"+e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDePrioridades = prioridademodel.buscarTodos();
    }

    public PrioridadeMapeamento getPrioridademape() {
        return prioridademape;
    }

    public void setPrioridademape(PrioridadeMapeamento prioridademape) {
        this.prioridademape = prioridademape;
    }

    public PrioridadeModel getPrioridademodel() {
        return prioridademodel;
    }

    public void setPrioridademodel(PrioridadeModel prioridademodel) {
        this.prioridademodel = prioridademodel;
    }

    public List<PrioridadeMapeamento> getListaDePrioridades() {
        return listaDePrioridades;
    }

    public void setListaDePrioridades(List<PrioridadeMapeamento> listaDePrioridades) {
        this.listaDePrioridades = listaDePrioridades;
    }
    private List<PrioridadeMapeamento> listaDePrioridades;
}
