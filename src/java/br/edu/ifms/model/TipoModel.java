/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;
import br.edu.ifms.mapeamento.TipoMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class TipoModel extends Conexao{
    
     public void inserir(TipoMapeamento tipoMapeamento){
        super.inicializa();
        super.getSess().save(tipoMapeamento);
        super.executar();
    }
      public TipoMapeamento buscarPorId(Long id){
        TipoMapeamento tipoMapeamento;
        super.inicializa();
        tipoMapeamento = (TipoMapeamento) super.getSess().get(TipoMapeamento.class, id);
        super.executar();
        return tipoMapeamento;
    }
    public List<TipoMapeamento> buscarTodos(){
       List<TipoMapeamento> listaDeTipos = new ArrayList<>();
       super.inicializa();
       listaDeTipos = super.getSess().createQuery("from TipoMapeamento").list();
       super.executar();
       return listaDeTipos;
    }
}
