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
@Table(name = "tipocontacto", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Tipocontacto.findAll", query = "SELECT t FROM Tipocontacto t")})
public class Tipocontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipocontacto", nullable = false)
    private Integer idtipocontacto;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipocontacto", fetch = FetchType.LAZY)
    private List<Dadoscontacto> dadoscontactoList;

    public Tipocontacto() {
    }

    public Tipocontacto(Integer idtipocontacto) {
        this.idtipocontacto = idtipocontacto;
    }

    public Integer getIdtipocontacto() {
        return idtipocontacto;
    }

    public void setIdtipocontacto(Integer idtipocontacto) {
        this.idtipocontacto = idtipocontacto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Dadoscontacto> getDadoscontactoList() {
        return dadoscontactoList;
    }

    public void setDadoscontactoList(List<Dadoscontacto> dadoscontactoList) {
        this.dadoscontactoList = dadoscontactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipocontacto != null ? idtipocontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocontacto)) {
            return false;
        }
        Tipocontacto other = (Tipocontacto) object;
        if ((this.idtipocontacto == null && other.idtipocontacto != null) || (this.idtipocontacto != null && !this.idtipocontacto.equals(other.idtipocontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Tipocontacto[ idtipocontacto=" + idtipocontacto + " ]";
    }
    
}
