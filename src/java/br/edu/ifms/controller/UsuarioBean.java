/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

/**
 *
 * @author Danielly
 */
import br.edu.ifms.mapeamento.FuncionarioMapeamento;
import br.edu.ifms.mapeamento.UsuarioMapeamento;
import br.edu.ifms.model.FuncionarioModel;
import br.edu.ifms.model.UsuarioModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    private UsuarioMapeamento usuariomape;
    private UsuarioModel usuariomodel;
    private FuncionarioMapeamento fmape;
    private FuncionarioModel fmodel;
    private String msg;
    private List<UsuarioMapeamento> listaDeUsuarios;

    public UsuarioBean() {
        this.usuariomape = new UsuarioMapeamento();
        this.usuariomodel = new UsuarioModel();
        this.listaDeUsuarios = new ArrayList<>();
        this.fmape = new FuncionarioMapeamento();
        this.fmodel = new FuncionarioModel();
    }

    public void salvar() {
        fmape = this.fmodel.buscarPorId(fmape.getId());
        usuariomape.setFuncionario(fmape);

        try {
            usuariomodel.inserir(usuariomape);
            this.usuariomape = new UsuarioMapeamento();
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
        this.listaDeUsuarios = usuariomodel.buscarTodos();
    }

    public UsuarioMapeamento getUsuariomape() {
        return usuariomape;
    }

    public void setUsuariomape(UsuarioMapeamento usuariomape) {
        this.usuariomape = usuariomape;
    }

    public UsuarioModel getUsuariomodel() {
        return usuariomodel;
    }

    public void setUsuariomodel(UsuarioModel usuariomodel) {
        this.usuariomodel = usuariomodel;
    }

    public FuncionarioMapeamento getFmape() {
        return fmape;
    }

    public void setFmape(FuncionarioMapeamento fmape) {
        this.fmape = fmape;
    }

    public FuncionarioModel getFmodel() {
        return fmodel;
    }

    public void setFmodel(FuncionarioModel fmodel) {
        this.fmodel = fmodel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<UsuarioMapeamento> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(List<UsuarioMapeamento> listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }

}
