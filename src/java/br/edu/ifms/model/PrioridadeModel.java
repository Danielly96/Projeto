/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.PrioridadeMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class PrioridadeModel  extends Conexao{
     public void inserir(PrioridadeMapeamento prioridadeMapeamento){
        super.inicializa();
        super.getSess().save(prioridadeMapeamento);
        super.executar();
    }
     public PrioridadeMapeamento buscarPorId(Long id){
        PrioridadeMapeamento prioridadeMapeamento;
        super.inicializa();
        prioridadeMapeamento = (PrioridadeMapeamento) super.getSess().get(PrioridadeMapeamento.class, id);
        super.executar();
        return prioridadeMapeamento;
    }
    public List<PrioridadeMapeamento> buscarTodos(){
       List<PrioridadeMapeamento> listaDePrioridades = new ArrayList<>();
       super.inicializa();
       listaDePrioridades = super.getSess().createQuery("from PrioridadeMapeamento").list();
       super.executar();
       return listaDePrioridades;
    }
}
