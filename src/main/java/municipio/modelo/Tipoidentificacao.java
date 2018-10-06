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
@Table(name = "tipoidentificacao", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Tipoidentificacao.findAll", query = "SELECT t FROM Tipoidentificacao t")})
public class Tipoidentificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoidentificacao", nullable = false)
    private Integer idtipoidentificacao;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoidentificacao", fetch = FetchType.LAZY)
    private List<Clientesingular> clientesingularList;

    public Tipoidentificacao() {
    }

    public Tipoidentificacao(Integer idtipoidentificacao) {
        this.idtipoidentificacao = idtipoidentificacao;
    }

    public Integer getIdtipoidentificacao() {
        return idtipoidentificacao;
    }

    public void setIdtipoidentificacao(Integer idtipoidentificacao) {
        this.idtipoidentificacao = idtipoidentificacao;
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
        hash += (idtipoidentificacao != null ? idtipoidentificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoidentificacao)) {
            return false;
        }
        Tipoidentificacao other = (Tipoidentificacao) object;
        if ((this.idtipoidentificacao == null && other.idtipoidentificacao != null) || (this.idtipoidentificacao != null && !this.idtipoidentificacao.equals(other.idtipoidentificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Tipoidentificacao[ idtipoidentificacao=" + idtipoidentificacao + " ]";
    }
    
}
