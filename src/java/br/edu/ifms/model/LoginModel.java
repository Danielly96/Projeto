/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.LoginMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class LoginModel extends Conexao {

    public void inserir(LoginMapeamento login) {
        super.inicializa();
        super.getSess().save(login);
        super.executar();
    }

    public LoginMapeamento buscarPorId(Long id) {
        LoginMapeamento login;
        super.inicializa();
       login = (LoginMapeamento) super.getSess().get(LoginMapeamento.class, id);
        super.executar();
        return login;
    }

    public List<LoginMapeamento> buscarTodos() {
        List<LoginMapeamento> listaDeLogin = new ArrayList<>();
        super.inicializa();
        listaDeLogin = super.getSess().createQuery("from LoginMapeamento").list();
        super.executar();
        return listaDeLogin;
    }

    public void excluir(LoginMapeamento login) {
        super.inicializa();
        super.getSess().delete(login);
        super.executar();
    }

    public void update(LoginMapeamento login) {
        super.inicializa();
        super.getSess().update(login);
        super.executar();

    }
}
