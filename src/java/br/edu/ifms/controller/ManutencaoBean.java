/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.ManutencaoMapeamento;
import br.edu.ifms.model.ManutencaoModel;
import br.edu.ifms.util.RetornoAcao;
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
public class ManutencaoBean implements Serializable {

    private ManutencaoMapeamento manutencaomape;
    private ManutencaoModel manutencaomodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<ManutencaoMapeamento> listaDeManutencoes;

    public ManutencaoBean() {
        this.manutencaomape = new ManutencaoMapeamento();
        try {
            this.manutencaomodel = new ManutencaoModel();
        } catch (Exception e) {
            this.msg = e.getMessage();
        }
        this.listaDeManutencoes = new ArrayList<>();

    }

    public void salvar() {
        try {
            manutencaomodel.inserir(manutencaomape);
            this.manutencaomape = new ManutencaoMapeamento();
            // this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            //this.msg ="Erro"+e.getMessage();
        }
    }

    public void buscarTodos() {
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

    public List<ManutencaoMapeamento> getListaDeManutencoes() {
        return listaDeManutencoes;
    }

    public void setListaDeManutencoes(List<ManutencaoMapeamento> listaDeManutencoes) {
        this.listaDeManutencoes = listaDeManutencoes;
    }
}
