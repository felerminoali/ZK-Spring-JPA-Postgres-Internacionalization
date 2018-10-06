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
@Table(name = "sexo", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Sexo.findAll", query = "SELECT s FROM Sexo s")})
public class Sexo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsexo", nullable = false)
    private Integer idsexo;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sexo", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList;

    public Sexo() {
    }

    public Sexo(Integer idsexo) {
        this.idsexo = idsexo;
    }

    public Integer getIdsexo() {
        return idsexo;
    }

    public void setIdsexo(Integer idsexo) {
        this.idsexo = idsexo;
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
        hash += (idsexo != null ? idsexo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sexo)) {
            return false;
        }
        Sexo other = (Sexo) object;
        if ((this.idsexo == null && other.idsexo != null) || (this.idsexo != null && !this.idsexo.equals(other.idsexo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Sexo[ idsexo=" + idsexo + " ]";
    }
    
}
