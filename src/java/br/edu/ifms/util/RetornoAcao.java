/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.util;

/**
 *
 * @author frank
 */
public class RetornoAcao {
    private String msg;
    private boolean erro;
    
    public RetornoAcao(){
        this.msg = "";
        this.erro = false;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isErro() {
        return erro;
    }

    public void setErro(boolean erro) {
        this.erro = erro;
    }
    
    
}
