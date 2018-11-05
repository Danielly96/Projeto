/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.util.RetornoAcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Danielly
 */
@ManagedBean
@ViewScoped
public class MaquinaBean implements Serializable {

    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<MaquinaMapeamento> listaDeMaquinas;

    public MaquinaBean() {
        this.maquinaMapeamento = new MaquinaMapeamento();
        try {
              this.maquinaModel = new MaquinaModel();
        } catch (Exception e) {
            this.msg = e.getMessage();
        }
        this.listaDeMaquinas = new ArrayList<>();
    
    } 

    public void salvar() {
        try {
            maquinaModel.inserir(maquinaMapeamento);
            this.maquinaMapeamento = new MaquinaMapeamento();
            this.msg = "Salvo com sucesso!";
        } catch (Exception e) {
            this.msg = "Erro " + e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDeMaquinas = maquinaModel.buscarTodos();
                      
    }
    /*public void excluir(){
    this.listaDeMaquinas = mmodel.buscarTodos();
    this.mm = new MaquinaMapeamento();
    mmodel.excluir(mm)
   }////novo
    /*public void excluir() {
        try {
            mmodel.remove(mm);
            this.mm = new MaquinaMapeamento();
            this.msg = "Salvo com sucesso!";
        } catch (Exception e) {
            this.msg = "Erro " + e.getMessage();
        }
    }*/

    public MaquinaMapeamento getMaquinaMapeamento() {
        return maquinaMapeamento;
    }

    public void setMaquinaMapeamento(MaquinaMapeamento maquinaMapeamento) {
        this.maquinaMapeamento = maquinaMapeamento;
    }

    public MaquinaModel getMaquinaModel() {
        return maquinaModel;
    }

    public void setMaquinaModel(MaquinaModel mmodel) {
        this.maquinaModel = mmodel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RetornoAcao getRetornoAcao() {
        return retornoAcao;
    }

    public void setRetornoAcao(RetornoAcao retornoAcao) {
        this.retornoAcao = retornoAcao;
    }

    public List<MaquinaMapeamento> getListaDeMaquinas() {
        return listaDeMaquinas;
    }

    public void setListaDeMaquinas(List<MaquinaMapeamento> listaDeMaquinas) {
        this.listaDeMaquinas = listaDeMaquinas;
    }

}
