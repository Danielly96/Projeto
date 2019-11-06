/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.PecaMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class PecaModel  extends Conexao{
     public void inserir(PecaMapeamento pecaMapeamento){
        super.inicializa();
        super.getSess().save(pecaMapeamento);
        super.executar();
    }
       public PecaMapeamento buscarPorId(Long id){
        PecaMapeamento pecaMapeamento;
        super.inicializa();
        pecaMapeamento = (PecaMapeamento) super.getSess().get(PecaMapeamento.class, id);
        super.executar();
        return pecaMapeamento;
    }
    public List<PecaMapeamento> buscarTodos(){
       List<PecaMapeamento> listaDePecas = new ArrayList<>();
       super.inicializa();
       listaDePecas = super.getSess().createQuery("from PecaMapeamento").list();
       super.executar();
       return listaDePecas;
    }
    public void excluir(PecaMapeamento peca){
        super.inicializa();
        super.getSess().delete(peca);
        super.executar();
    }
    
    public void update(PecaMapeamento pecaMapeamento) {
        super.inicializa();
        super.getSess().update(pecaMapeamento);
        super.executar();

    }
}
