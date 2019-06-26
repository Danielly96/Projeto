/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.mapeamento.SubconjuntoMapeamento;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.model.SubconjuntoModel;
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
public class SubconjuntoBean implements Serializable {

    private SubconjuntoMapeamento subconjuntomape;
    private SubconjuntoModel subconjuntomodel;
    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<SubconjuntoMapeamento> listaDeSubconjuntos;

    public SubconjuntoBean() {
        this.subconjuntomape = new SubconjuntoMapeamento();
        this.subconjuntomodel = new SubconjuntoModel();
        this.listaDeSubconjuntos = new ArrayList<>();
        this.maquinaMapeamento= new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
    }

    public void salvar() {
        maquinaMapeamento = this.maquinaModel.buscarPorId(maquinaMapeamento.getId());
      subconjuntomape.setMaquina(maquinaMapeamento);
        try {
            subconjuntomodel.inserir(subconjuntomape);
            this.subconjuntomape = new SubconjuntoMapeamento();
            this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
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

    public List<SubconjuntoMapeamento> getListaDeSubconjuntos() {
        return listaDeSubconjuntos;
    }

    public void setListaDeSubconjuntos(List<SubconjuntoMapeamento> listaDeSubconjuntos) {
        this.listaDeSubconjuntos = listaDeSubconjuntos;
    }
}
