/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.UsuarioMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class UsuarioModel extends Conexao{
    public void inserir(UsuarioMapeamento usuarioMapeamento) {
        super.inicializa();
        super.getSess().save(usuarioMapeamento);
        super.executar();
    }

    public UsuarioMapeamento buscarPorId(Long id) {
        UsuarioMapeamento usuarioMapeamento;
        super.inicializa();
       usuarioMapeamento = (UsuarioMapeamento) super.getSess().get(UsuarioMapeamento.class, id);
        super.executar();
        return usuarioMapeamento;
    }

    public List<UsuarioMapeamento> buscarTodos() {
        List<UsuarioMapeamento> listaDeUsuarios = new ArrayList<>();
        super.inicializa();
       listaDeUsuarios = super.getSess().createQuery("from UsuarioMapeamento").list();
        super.executar();
        return listaDeUsuarios;
    }
      public void excluir(UsuarioMapeamento usuario) {
        super.inicializa();
        super.getSess().delete(usuario);
        super.executar();
    }

    public void update(UsuarioMapeamento usuario) {
        super.inicializa();
        super.getSess().update(usuario);
        super.executar();

    }
}
