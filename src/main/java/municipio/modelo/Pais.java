/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "pais", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")})
public class Pais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpais", nullable = false)
    private Integer idpais;
    @Column(name = "nome", length = 2147483647)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais", fetch = FetchType.LAZY)
    private List<Endereco> enderecoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cidadania", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidade", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paisemissao", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList2;

    public Pais() {
    }

    public Pais(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public List<Clientesingular> getClientesingularList() {
        return clientesingularList;
    }

    public void setClientesingularList(List<Clientesingular> clientesingularList) {
        this.clientesingularList = clientesingularList;
    }

    public List<Clientesingular> getClientesingularList1() {
        return clientesingularList1;
    }

    public void setClientesingularList1(List<Clientesingular> clientesingularList1) {
        this.clientesingularList1 = clientesingularList1;
    }

    public List<Clientesingular> getClientesingularList2() {
        return clientesingularList2;
    }

    public void setClientesingularList2(List<Clientesingular> clientesingularList2) {
        this.clientesingularList2 = clientesingularList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Pais[ idpais=" + idpais + " ]";
    }
    
}
