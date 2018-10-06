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
@Table(name = "metodocontacto", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Metodocontacto.findAll", query = "SELECT m FROM Metodocontacto m")})
public class Metodocontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmetodocontacto", nullable = false)
    private Integer idmetodocontacto;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metodocontactopreferido", fetch = FetchType.LAZY)
    private List<Dadoscontacto> dadoscontactoList;

    public Metodocontacto() {
    }

    public Metodocontacto(Integer idmetodocontacto) {
        this.idmetodocontacto = idmetodocontacto;
    }

    public Integer getIdmetodocontacto() {
        return idmetodocontacto;
    }

    public void setIdmetodocontacto(Integer idmetodocontacto) {
        this.idmetodocontacto = idmetodocontacto;
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
        hash += (idmetodocontacto != null ? idmetodocontacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metodocontacto)) {
            return false;
        }
        Metodocontacto other = (Metodocontacto) object;
        if ((this.idmetodocontacto == null && other.idmetodocontacto != null) || (this.idmetodocontacto != null && !this.idmetodocontacto.equals(other.idmetodocontacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Metodocontacto[ idmetodocontacto=" + idmetodocontacto + " ]";
    }
    
}
