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
@Table(name = "tipoentidade", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Tipoentidade.findAll", query = "SELECT t FROM Tipoentidade t")})
public class Tipoentidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoentidade", nullable = false)
    private Integer idtipoentidade;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoentidade", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public Tipoentidade() {
    }

    public Tipoentidade(Integer idtipoentidade) {
        this.idtipoentidade = idtipoentidade;
    }

    public Integer getIdtipoentidade() {
        return idtipoentidade;
    }

    public void setIdtipoentidade(Integer idtipoentidade) {
        this.idtipoentidade = idtipoentidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoentidade != null ? idtipoentidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoentidade)) {
            return false;
        }
        Tipoentidade other = (Tipoentidade) object;
        if ((this.idtipoentidade == null && other.idtipoentidade != null) || (this.idtipoentidade != null && !this.idtipoentidade.equals(other.idtipoentidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Tipoentidade[ idtipoentidade=" + idtipoentidade + " ]";
    }
    
}
