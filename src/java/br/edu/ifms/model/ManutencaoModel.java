/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;
import br.edu.ifms.mapeamento.ManutencaoMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class ManutencaoModel extends Conexao{
    
     public void inserir(ManutencaoMapeamento manutencaoMapeamento){
        super.inicializa();
        super.getSess().save(manutencaoMapeamento);
        super.executar();
    }
    public ManutencaoMapeamento buscarPorId(Long id){
        ManutencaoMapeamento manutencaoMapeamento;
        super.inicializa();
        manutencaoMapeamento = (ManutencaoMapeamento) super.getSess().get(ManutencaoMapeamento.class, id);
        super.executar();
        return manutencaoMapeamento;
    }
     
    public List<ManutencaoMapeamento> buscarTodos(){
       List<ManutencaoMapeamento> listaDeManutencoes = new ArrayList<>();
       super.inicializa();
       listaDeManutencoes = super.getSess().createQuery("from ManutencaoMapeamento").list();
       super.executar();
       return listaDeManutencoes;
    }
    
    public List<ManutencaoMapeamento> buscarTodosEmManutencao(){
       List<ManutencaoMapeamento> listaDeManutencoes = new ArrayList<>();
       super.inicializa();
       listaDeManutencoes = super.getSess().createQuery("from ManutencaoMapeamento where emManutencao = true").list();
       super.executar();
       return listaDeManutencoes;
    }
     public List<ManutencaoMapeamento> buscarTodosFinalizados(){
       List<ManutencaoMapeamento> listaDeManutencoes = new ArrayList<>();
       super.inicializa();
       listaDeManutencoes = super.getSess().createQuery("from ManutencaoMapeamento where emManutencao = false").list();
       super.executar();
       return listaDeManutencoes;
    }
    
    public void excluir(ManutencaoMapeamento manutencao){
        super.inicializa();
        super.getSess().delete(manutencao);
        super.executar();
    }
    
    public void update(ManutencaoMapeamento manutencaoMapeamento) {
        super.inicializa();
        super.getSess().update(manutencaoMapeamento);
        super.executar();

    }
}
