/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;
import javax.faces.bean.ManagedBean;
import br.edu.ifms.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginMB {
      private Usuario usuario = new Usuario();

  public String doEfetuarLogin() {
    if("gerente".equals(usuario.getLogin())
            && "123".equals(usuario.getSenha())) {
      return "Fluxograma3";
    } else {
      /* Cria uma mensagem. */
      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}