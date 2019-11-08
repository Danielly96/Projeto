package br.edu.ifms.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifms.mapeamento.UsuarioMapeamento;
import br.edu.ifms.model.UsuarioModel;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private UsuarioMapeamento usuario;
    private UsuarioModel usuarioModel;
    private String username;
    private String password;

    public LoginBean() {
        usuario = new UsuarioMapeamento();
        usuarioModel = new UsuarioModel();
    }

    public String login() {
        usuario = usuarioModel.buscarPorLogin(username);
        if (usuario != null) {
            if (usuario.getSenha().equals(password)) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("currentUser", usuario.getLogin());

                return "/view/principal.xhtml?faces-redirect=true";
            } else {
                //context.addMessage(null, new FacesMessage("A senha está incorreta"));
            }
        } else {
            //context.addMessage(null, new FacesMessage("O login informado não foi encontrado"));
        }
        return "/login.xhtml?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("currentUser");
        return "/areas.xhtml?faces-redirect=true";
    }

    public UsuarioMapeamento getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMapeamento usuario) {
        this.usuario = usuario;
    }

    public UsuarioModel getUsuarioModel() {
        return usuarioModel;
    }

    public void setUsuarioModel(UsuarioModel usuarioModel) {
        this.usuarioModel = usuarioModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
