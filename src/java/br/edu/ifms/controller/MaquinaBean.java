/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FabricanteMapeamento;
import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.mapeamento.TipoMapeamento;
import br.edu.ifms.model.FabricanteModel;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.model.TipoModel;
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
    private TipoMapeamento tmape;
    private TipoModel tmodel;
    private FabricanteMapeamento fmape;
    private FabricanteModel fmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<MaquinaMapeamento> listaDeMaquinas;

    public MaquinaBean() {
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
        this.listaDeMaquinas = new ArrayList<>();
        this.tmape = new TipoMapeamento();
        this.tmodel = new TipoModel();
        this.fmape = new FabricanteMapeamento();
        this.fmodel = new FabricanteModel();
    }

    public void salvar() {
        tmape = this.tmodel.buscarPorId(tmape.getId());
        maquinaMapeamento.setTipo(tmape);
        fmape = this.fmodel.buscarPorId(fmape.getId());
        maquinaMapeamento.setFabricante(fmape);

        try {
            maquinaModel.inserir(maquinaMapeamento);
            this.maquinaMapeamento = new MaquinaMapeamento();
            this.msg = "Salvo com Sucesso!";
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
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
