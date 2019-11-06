/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FabricanteMapeamento;
import br.edu.ifms.model.FabricanteModel;
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
public class FabricanteBean implements Serializable {

    private FabricanteMapeamento fmap;
    private FabricanteModel fmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<FabricanteMapeamento> listaDeFabricantes;

    public FabricanteBean() {
        this.fmap = new FabricanteMapeamento();
        this.fmodel = new FabricanteModel();
        this.msg = "";
        this.listaDeFabricantes = new ArrayList<>();
    }

    public void inicializa() {
        this.fmap = null;
        this.retornoAcao = null;
        this.fmap = new FabricanteMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        try {
            fmodel.inserir(fmap);
            this.fmap = new FabricanteMapeamento();
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public String editar(Long fabricanteID) {
        this.fmap = fmodel.buscarPorId(fabricanteID);

        return "editarFabricante.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        try {
            fmodel.update(fmap);
             FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarFabricante.xhtml?faces-redirect=true";
    }

    public void buscarTodos() {
        inicializa();
        this.listaDeFabricantes = fmodel.buscarTodos();
    }

    public void excluir(Long fabricanteID) {
        this.fmodel.excluir(fmodel.buscarPorId(fabricanteID));
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

    public List<FabricanteMapeamento> getListaDeFabricantes() {
        return listaDeFabricantes;
    }

    public void setListaDeFabricantes(List<FabricanteMapeamento> listaDeFabricantes) {
        this.listaDeFabricantes = listaDeFabricantes;
    }

}
