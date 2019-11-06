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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Danielly
 */
@ManagedBean
@SessionScoped
public class MaquinaBean implements Serializable {

    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private TipoMapeamento tmape;
    private TipoModel tmodel;
    private FabricanteMapeamento fmape;
    private FabricanteModel fmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private StreamedContent imagem;
    private List<MaquinaMapeamento> listaDeMaquinas;

    public MaquinaBean() {
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
        this.maquinaModel = new MaquinaModel();
        this.listaDeMaquinas = new ArrayList<>();
        this.tmape = new TipoMapeamento();
        this.tmodel = new TipoModel();
        this.fmape = new FabricanteMapeamento();
        this.fmodel = new FabricanteModel();
        this.msg = "";
    }

    public void inicializa() {
        this.maquinaMapeamento = null;
        this.tmape = null;
        this.fmape = null;
        this.retornoAcao = null;
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.tmape = new TipoMapeamento();
        this.fmape = new FabricanteMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        tmape = this.tmodel.buscarPorId(tmape.getId());
        maquinaMapeamento.setTipo(tmape);
        fmape = this.fmodel.buscarPorId(fmape.getId());
        maquinaMapeamento.setFabricante(fmape);

        try {
            maquinaModel.inserir(maquinaMapeamento);
            this.maquinaMapeamento = new MaquinaMapeamento();
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodos() {
        inicializa();
        this.listaDeMaquinas = maquinaModel.buscarTodos();

    }

    public String editar(Long maquinaID) {
        this.maquinaMapeamento = maquinaModel.buscarPorId(maquinaID);

        return "editarMaquina.xhtml?faces-redirect=true";
    }

    public String salvarEdicao() {
        tmape = this.tmodel.buscarPorId(tmape.getId());
        maquinaMapeamento.setTipo(tmape);
        fmape = this.fmodel.buscarPorId(fmape.getId());
        maquinaMapeamento.setFabricante(fmape);

        try {
            maquinaModel.update(maquinaMapeamento);
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        return "cadastrarMaquina.xhtml?faces-redirect=true";
    }

    public void excluir(Long maquinaID) {
        this.maquinaModel.excluir(maquinaModel.buscarPorId(maquinaID));
    }

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

    public TipoMapeamento getTmape() {
        return tmape;
    }

    public void setTmape(TipoMapeamento tmape) {
        this.tmape = tmape;
    }

    public TipoModel getTmodel() {
        return tmodel;
    }

    public void setTmodel(TipoModel tmodel) {
        this.tmodel = tmodel;
    }

    public FabricanteMapeamento getFmape() {
        return fmape;
    }

    public void setFmape(FabricanteMapeamento fmape) {
        this.fmape = fmape;
    }

    public FabricanteModel getFmodel() {
        return fmodel;
    }

    public void setFmodel(FabricanteModel fmodel) {
        this.fmodel = fmodel;
    }

    public StreamedContent getImagem() {
        return imagem;
    }

    public void setImagem(StreamedContent imagem) {
        this.imagem = imagem;
    }

}
