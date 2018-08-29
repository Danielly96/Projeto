/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.mapeamento;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Danielly
 */
@Entity
@PrimaryKeyJoinColumn(name="idFrabricanteMapeamento")
@Table (name ="fabricante")
public class FabricanteMapeamento extends MaquinaMapeamento{
    @Id
    @GeneratedValue
    private long id; 
    private String nome;
    private String telefone;
    private String email;
    @OneToMany(mappedBy="fabricante", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private Collection maquinas;

    public FabricanteMapeamento(long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public FabricanteMapeamento() {
  
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
