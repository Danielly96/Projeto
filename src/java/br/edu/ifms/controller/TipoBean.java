/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.TipoMapeamento;
import br.edu.ifms.model.TipoModel;
import br.edu.ifms.util.RetornoAcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Danielly
 */
@ManagedBean
@SessionScoped
public class TipoBean implements Serializable {

    private TipoMapeamento tmap;
    private TipoModel tmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<TipoMapeamento> listaDeTipos;

    public TipoBean() {
        this.tmap = new TipoMapeamento();
        this.tmodel = new TipoModel();
        this.msg = "";
        this.listaDeTipos = new ArrayList<>();
    }

    public void inicializa() {
        this.tmap = null;
        this.retornoAcao = null;
        this.tmap = new TipoMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        try {
            tmodel.inserir(tmap);
            this.tmap = new TipoMapeamento();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);

        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
        inicializa();
        this.listaDeTipos = tmodel.buscarTodos();
    }

    public String editar(Long tipoID) {
        this.tmap = tmodel.buscarPorId(tipoID);

        return "editarTipoMaquina.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        try {
            tmodel.update(tmap);
            this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarTipoMaquina.xhtml?faces-redirect=true";
    }

    public void excluir(Long tipoID) {
        this.tmodel.excluir(tmodel.buscarPorId(tipoID));
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
