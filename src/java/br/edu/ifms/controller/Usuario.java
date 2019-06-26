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
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Usuario implements Serializable{
private UsuarioMapeamento usuariomape;
private FuncionarioMapeamento fmape;
private FuncionarioModel fmodel;
private List<UsuarioMapeamento> listaDeUsuarios;
}
