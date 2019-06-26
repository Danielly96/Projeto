/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.model;

import br.edu.ifms.mapeamento.UsuarioMapeamento;
import br.edu.ifms.util.Conexao;

/**
 *
 * @author Danielly
 */
class UsuarioModel extends Conexao{
      public void inserir(UsuarioMapeamento usuarioMapeamento){
        super.inicializa();
        super.getSess().save(usuarioMapeamento);
        super.executar();
    }
}
