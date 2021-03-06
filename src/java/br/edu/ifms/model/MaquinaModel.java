/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.util.Conexao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danielly
 */
public class MaquinaModel extends Conexao {

    public void inserir(MaquinaMapeamento maquinaMapeamento) {
        super.inicializa();
        super.getSess().save(maquinaMapeamento);
        super.executar();

    }

    public MaquinaMapeamento buscarPorId(Long id) {
        MaquinaMapeamento maquinaMapeamento;
        super.inicializa();
        maquinaMapeamento = (MaquinaMapeamento) super.getSess().get(MaquinaMapeamento.class, id);
        super.executar();
        return maquinaMapeamento;
    }

    public List<MaquinaMapeamento> buscarTodos() {
        List<MaquinaMapeamento> listaDeMaquinas = new ArrayList<>();
        super.inicializa();
        listaDeMaquinas = super.getSess().createQuery("from MaquinaMapeamento").list();
        super.executar();
        return listaDeMaquinas;
    }

    public void excluir(MaquinaMapeamento maquina) {
        super.inicializa();
        super.getSess().delete(maquina);
        super.executar();
    }

    public void update(MaquinaMapeamento maquinaMapeamento) {
        super.inicializa();
        super.getSess().update(maquinaMapeamento);
        super.executar();

    }
}
