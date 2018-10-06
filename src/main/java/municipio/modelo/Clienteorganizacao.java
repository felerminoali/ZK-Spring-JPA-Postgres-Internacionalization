/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "clienteorganizacao", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Clienteorganizacao.findAll", query = "SELECT c FROM Clienteorganizacao c")})
public class Clienteorganizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Long idcliente;
    @Column(name = "nrregisto", length = 2147483647)
    private String nrregisto;
    @Column(name = "nomeregistado", length = 2147483647)
    private String nomeregistado;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "tipoorganizacao", referencedColumnName = "idtipoorganizacao", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipoorganizacao tipoorganizacao;

    public Clienteorganizacao() {
    }

    public Clienteorganizacao(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNrregisto() {
        return nrregisto;
    }

    public void setNrregisto(String nrregisto) {
        this.nrregisto = nrregisto;
    }

    public String getNomeregistado() {
        return nomeregistado;
    }

    public void setNomeregistado(String nomeregistado) {
        this.nomeregistado = nomeregistado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tipoorganizacao getTipoorganizacao() {
        return tipoorganizacao;
    }

    public void setTipoorganizacao(Tipoorganizacao tipoorganizacao) {
        this.tipoorganizacao = tipoorganizacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteorganizacao)) {
            return false;
        }
        Clienteorganizacao other = (Clienteorganizacao) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Clienteorganizacao[ idcliente=" + idcliente + " ]";
    }
    
}
