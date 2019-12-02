/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.controller;

import br.edu.ifms.mapeamento.FuncionarioMapeamento;
import br.edu.ifms.mapeamento.ManutencaoMapeamento;
import br.edu.ifms.mapeamento.MaquinaMapeamento;
import br.edu.ifms.mapeamento.PrioridadeMapeamento;
import br.edu.ifms.mapeamento.SubconjuntoMapeamento;
import br.edu.ifms.model.FuncionarioModel;
import br.edu.ifms.model.ManutencaoModel;
import br.edu.ifms.model.MaquinaModel;
import br.edu.ifms.model.PrioridadeModel;
import br.edu.ifms.model.SubconjuntoModel;
import br.edu.ifms.util.RetornoAcao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Danielly
 */
@ManagedBean
@SessionScoped
public class FluxogramaBean implements Serializable {

    private ManutencaoMapeamento manutencaomape;
    private ManutencaoModel manutencaomodel;
    private MaquinaMapeamento maquinaMapeamento;
    private MaquinaModel maquinaModel;
    private SubconjuntoModel subconjuntoModel;
    private PrioridadeMapeamento prioridademape;
    private PrioridadeModel prioridademodel;
    private FuncionarioMapeamento fmape;
    private FuncionarioModel fmodel;
    private String msg;
    private RetornoAcao retornoAcao;
    private List<ManutencaoMapeamento> listaDeManutencoes;
    private List<SubconjuntoMapeamento> listaDeSubconjuntos;

    public FluxogramaBean() {
        this.manutencaomape = new ManutencaoMapeamento();
        this.manutencaomodel = new ManutencaoModel();
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.maquinaModel = new MaquinaModel();
        this.prioridademape = new PrioridadeMapeamento();
        this.prioridademodel = new PrioridadeModel();
        this.fmape = new FuncionarioMapeamento();
        this.fmodel = new FuncionarioModel();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
        this.listaDeManutencoes = new ArrayList<>();
        this.listaDeSubconjuntos = new ArrayList<>();
        this.subconjuntoModel = new SubconjuntoModel();
    }

    public void inicializa() {
        this.manutencaomape = null;
        this.maquinaMapeamento = null;
        this.prioridademape = null;
        this.fmape = null;
        this.retornoAcao = null;
        this.manutencaomape = new ManutencaoMapeamento();
        this.maquinaMapeamento = new MaquinaMapeamento();
        this.prioridademape = new PrioridadeMapeamento();
        this.fmape = new FuncionarioMapeamento();
        this.msg = "";
        this.retornoAcao = new RetornoAcao();
    }

    public void salvar() {
        maquinaMapeamento = this.maquinaModel.buscarPorId(maquinaMapeamento.getId());
        manutencaomape.setMaquina(maquinaMapeamento);
        prioridademape = this.prioridademodel.buscarPorId(prioridademape.getId());
        manutencaomape.setPrioridade(prioridademape);
        fmape = this.fmodel.buscarPorId(fmape.getId());
        manutencaomape.setFuncionario(fmape);

        //a partir da data de identificação somar os dias para a previsão de manutenção      
        Calendar c = Calendar.getInstance();
        c.setTime(manutencaomape.getDataQueIdentificou());
        c.add(Calendar.DATE, prioridademape.getQntdias());
        manutencaomape.setDataManutencaoMarcada(c.getTime());
        //setando que está em manutenção
        manutencaomape.setEmManutencao(true);
        try {
            manutencaomodel.inserir(manutencaomape);
            this.manutencaomape = new ManutencaoMapeamento();
          FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
    }

    public void buscarTodosEmManutencao() {
        inicializa();
        this.listaDeManutencoes = manutencaomodel.buscarTodosEmManutencao();
        
       // manutencaomape.setEmManutencao(true);
    }
    
    public void buscarTodosSubconjuntos(Long idMaquina) {
        this.listaDeSubconjuntos = subconjuntoModel.buscarTodosDaMaquina(idMaquina);
    }

    public String chamadaDoFluxograma(Long id){
         this.maquinaMapeamento = maquinaModel.buscarPorId(id);

        return "maquinaSelecionada.xhtml?faces-redirect=true";
    }
    
    public String editar(Long manutencaoID) {
        this.manutencaomape = manutencaomodel.buscarPorId(manutencaoID);

        return "editarManutencao.xhtml?faces-redirect=true";
    }
    
    public String salvarEdicao() {               
        fmape = this.fmodel.buscarPorId(fmape.getId());
        manutencaomape.setFuncionario(fmape);

        //a partir da data de identificação somar os dias para a previsão de manutenção      
        //Calendar c = Calendar.getInstance();
        //c.setTime(manutencaomape.getDataQueIdentificou());
        //c.add(Calendar.DATE, prioridademape.getQntdias());
        //manutencaomape.setDataManutencaoMarcada(c.getTime());
        //setando que está em manutenção
        manutencaomape.setEmManutencao(false);
        try {
            manutencaomodel.update(manutencaomape);
           FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage("Salvo com sucesso!"));

            FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getFlash().setKeepMessages(true);
        } catch (Exception e) {
            this.msg = "Erro" + e.getMessage();
        }
        
        return "finalizadas.xhtml?faces-redirect=true";
    }
    
     public void excluir(Long manutencaoID) {
        this.manutencaomodel.excluir(manutencaomodel.buscarPorId(manutencaoID));        
    }

    public ManutencaoMapeamento getManutencaomape() {
        return manutencaomape;
    }

    public void setManutencaomape(ManutencaoMapeamento Manutencaomape) {
        this.manutencaomape = Manutencaomape;
    }

    public ManutencaoModel getManutencaomodel() {
        return manutencaomodel;
    }

    public void setManutencaomodel(ManutencaoModel Manutencaomodel) {
        this.manutencaomodel = Manutencaomodel;
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

    public List<ManutencaoMapeamento> getListaDeManutencoes() {
        return listaDeManutencoes;
    }

    public void setListaDeManutencoes(List<ManutencaoMapeamento> listaDeManutencoes) {
        this.listaDeManutencoes = listaDeManutencoes;
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

    public void setMaquinaModel(MaquinaModel maquinaModel) {
        this.maquinaModel = maquinaModel;
    }

    public PrioridadeMapeamento getPrioridademape() {
        return prioridademape;
    }

    public void setPrioridademape(PrioridadeMapeamento prioridademape) {
        this.prioridademape = prioridademape;
    }

    public PrioridadeModel getPrioridademodel() {
        return prioridademodel;
    }

    public void setPrioridademodel(PrioridadeModel prioridademodel) {
        this.prioridademodel = prioridademodel;
    }

    public FuncionarioMapeamento getFmape() {
        return fmape;
    }

    public void setFmape(FuncionarioMapeamento fmape) {
        this.fmape = fmape;
    }

    public FuncionarioModel getFmodel() {
        return fmodel;
    }

    public void setFmodel(FuncionarioModel fmodel) {
        this.fmodel = fmodel;
    }

    public SubconjuntoModel getSubconjuntoModel() {
        return subconjuntoModel;
    }

    public void setSubconjuntoModel(SubconjuntoModel subconjuntoModel) {
        this.subconjuntoModel = subconjuntoModel;
    }

    public List<SubconjuntoMapeamento> getListaDeSubconjuntos() {
        return listaDeSubconjuntos;
    }

    public void setListaDeSubconjuntos(List<SubconjuntoMapeamento> listaDeSubconjuntos) {
        this.listaDeSubconjuntos = listaDeSubconjuntos;
    }
}
