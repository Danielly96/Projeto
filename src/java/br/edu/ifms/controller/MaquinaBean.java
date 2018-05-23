/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.model.MaquinaModel;
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

    private MaquinaMapeamento mm;  //
    private MaquinaModel mmodel;
    private String msg;
    private List<MaquinaMapeamento> listaDeMaquinas;

    public MaquinaBean() {
        this.mm = new MaquinaMapeamento();
        this.mmodel = new MaquinaModel();
        this.listaDeMaquinas = new ArrayList<>();
    
    } 

    public void salvar() {
        try {
            mmodel.inserir(mm);
            this.mm = new MaquinaMapeamento();
            this.msg = "Salvo com sucesso!";
        } catch (Exception e) {
            this.msg = "Erro " + e.getMessage();
        }
    }

    public void buscarTodos() {
        this.listaDeMaquinas = mmodel.buscarTodos();
                      
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
    public MaquinaMapeamento getMm() {
        return mm;
    }

    public void setMm(MaquinaMapeamento mm) {
        this.mm = mm;
    }

    public MaquinaModel getMmodel() {
        return mmodel;
    }

    public void setMmodel(MaquinaModel mmodel) {
        this.mmodel = mmodel;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MaquinaMapeamento> getListaDeMaquinas() {
        return listaDeMaquinas;
    }

    public void setListaDeMaquinas(List<MaquinaMapeamento> listaDeMaquinas) {
        this.listaDeMaquinas = listaDeMaquinas;
    }

}
