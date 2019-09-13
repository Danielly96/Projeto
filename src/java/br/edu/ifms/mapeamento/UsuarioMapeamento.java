/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "usuario")
public class UsuarioMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String login;
    private String senha;
    @ManyToOne()
    @JoinColumn(name = "idFuncionario", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private FuncionarioMapeamento funcionario;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FuncionarioMapeamento getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioMapeamento funcionario) {
        this.funcionario = funcionario;
    }

}
