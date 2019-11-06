/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.FabricanteMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class FabricanteModel extends Conexao {

    public void inserir(FabricanteMapeamento fabricanteMapeamento) {
        super.inicializa();
        super.getSess().save(fabricanteMapeamento);
        super.executar();
    }

    public FabricanteMapeamento buscarPorId(Long id) {
        FabricanteMapeamento fabricanteMapeamento;
        super.inicializa();
        fabricanteMapeamento = (FabricanteMapeamento) super.getSess().get(FabricanteMapeamento.class, id);
        super.executar();
        return fabricanteMapeamento;
    }

    public List<FabricanteMapeamento> buscarTodos() {
        List<FabricanteMapeamento> listaDeFabricantes = new ArrayList<>();
        super.inicializa();
        listaDeFabricantes = super.getSess().createQuery("from FabricanteMapeamento").list();
        super.executar();
        return listaDeFabricantes;
    }
      public void excluir(FabricanteMapeamento fabricante){
        super.inicializa();
        super.getSess().delete(fabricante);
        super.executar();
    }
        public void update(FabricanteMapeamento fabricanteMapeamento) {
        super.inicializa();
        super.getSess().update(fabricanteMapeamento);
        super.executar();

    }
}
