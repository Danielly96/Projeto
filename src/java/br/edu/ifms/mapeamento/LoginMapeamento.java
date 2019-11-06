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
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Danielly
 */
@Entity
@Table(name = "login")
public class LoginMapeamento implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne()
    @JoinColumn(name = "idUsuario", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    private UsuarioMapeamento usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UsuarioMapeamento getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioMapeamento usuario) {
        this.usuario = usuario;
    }
    
    
}
