/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.FuncionarioMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class FuncionarioModel extends Conexao {

    public void inserir(FuncionarioMapeamento funcionarioMapeamento) {
        super.inicializa();
        super.getSess().save(funcionarioMapeamento);
        super.executar();
    }

    public FuncionarioMapeamento buscarPorId(Long id) {
        FuncionarioMapeamento funcionarioMapeamento;
        super.inicializa();
       funcionarioMapeamento = (FuncionarioMapeamento) super.getSess().get(FuncionarioMapeamento.class, id);
        super.executar();
        return funcionarioMapeamento;
    }

    public List<FuncionarioMapeamento> buscarTodos() {
        List<FuncionarioMapeamento> listaDeFuncionarios = new ArrayList<>();
        super.inicializa();
        listaDeFuncionarios = super.getSess().createQuery("from FuncionarioMapeamento").list();
        super.executar();
        return listaDeFuncionarios;
    }
     public void excluir(FuncionarioMapeamento funcionario){
        super.inicializa();
        super.getSess().delete(funcionario);
        super.executar();
    }
       public void update(FuncionarioMapeamento funcionarioMapeamento) {
        super.inicializa();
        super.getSess().update(funcionarioMapeamento);
        super.executar();

    }
}
