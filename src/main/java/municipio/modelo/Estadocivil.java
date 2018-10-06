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
@Table(name = "estadocivil", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Estadocivil.findAll", query = "SELECT e FROM Estadocivil e")})
public class Estadocivil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestadocivil", nullable = false)
    private Integer idestadocivil;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoclivil", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList;

    public Estadocivil() {
    }

    public Estadocivil(Integer idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public Integer getIdestadocivil() {
        return idestadocivil;
    }

    public void setIdestadocivil(Integer idestadocivil) {
        this.idestadocivil = idestadocivil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Clientesingular> getClientesingularList() {
        return clientesingularList;
    }

    public void setClientesingularList(List<Clientesingular> clientesingularList) {
        this.clientesingularList = clientesingularList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestadocivil != null ? idestadocivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadocivil)) {
            return false;
        }
        Estadocivil other = (Estadocivil) object;
        if ((this.idestadocivil == null && other.idestadocivil != null) || (this.idestadocivil != null && !this.idestadocivil.equals(other.idestadocivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Estadocivil[ idestadocivil=" + idestadocivil + " ]";
    }
    
}
