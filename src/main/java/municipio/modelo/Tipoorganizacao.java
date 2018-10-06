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
@Table(name = "tipoorganizacao", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Tipoorganizacao.findAll", query = "SELECT t FROM Tipoorganizacao t")})
public class Tipoorganizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipoorganizacao", nullable = false)
    private Integer idtipoorganizacao;
    @Column(name = "descricao", length = 2147483647)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoorganizacao", fetch = FetchType.LAZY)
    private List<Clienteorganizacao> clienteorganizacaoList;

    public Tipoorganizacao() {
    }

    public Tipoorganizacao(Integer idtipoorganizacao) {
        this.idtipoorganizacao = idtipoorganizacao;
    }

    public Integer getIdtipoorganizacao() {
        return idtipoorganizacao;
    }

    public void setIdtipoorganizacao(Integer idtipoorganizacao) {
        this.idtipoorganizacao = idtipoorganizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Clienteorganizacao> getClienteorganizacaoList() {
        return clienteorganizacaoList;
    }

    public void setClienteorganizacaoList(List<Clienteorganizacao> clienteorganizacaoList) {
        this.clienteorganizacaoList = clienteorganizacaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoorganizacao != null ? idtipoorganizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoorganizacao)) {
            return false;
        }
        Tipoorganizacao other = (Tipoorganizacao) object;
        if ((this.idtipoorganizacao == null && other.idtipoorganizacao != null) || (this.idtipoorganizacao != null && !this.idtipoorganizacao.equals(other.idtipoorganizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Tipoorganizacao[ idtipoorganizacao=" + idtipoorganizacao + " ]";
    }
    
}
