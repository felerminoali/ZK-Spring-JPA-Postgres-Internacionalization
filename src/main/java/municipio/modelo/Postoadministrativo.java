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
@Table(name = "postoadministrativo", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Postoadministrativo.findAll", query = "SELECT p FROM Postoadministrativo p")})
public class Postoadministrativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpostoadministrativo", nullable = false)
    private Integer idpostoadministrativo;
    @Column(name = "descricao", length = 255)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postoadministrativo", fetch = FetchType.LAZY)
    private List<Endereco> enderecoList;

    public Postoadministrativo() {
    }

    public Postoadministrativo(Integer idpostoadministrativo) {
        this.idpostoadministrativo = idpostoadministrativo;
    }

    public Integer getIdpostoadministrativo() {
        return idpostoadministrativo;
    }

    public void setIdpostoadministrativo(Integer idpostoadministrativo) {
        this.idpostoadministrativo = idpostoadministrativo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpostoadministrativo != null ? idpostoadministrativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postoadministrativo)) {
            return false;
        }
        Postoadministrativo other = (Postoadministrativo) object;
        if ((this.idpostoadministrativo == null && other.idpostoadministrativo != null) || (this.idpostoadministrativo != null && !this.idpostoadministrativo.equals(other.idpostoadministrativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Postoadministrativo[ idpostoadministrativo=" + idpostoadministrativo + " ]";
    }
    
}
