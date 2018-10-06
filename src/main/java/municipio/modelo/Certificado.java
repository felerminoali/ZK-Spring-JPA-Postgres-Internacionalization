/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author user
 */
@Entity
@Table(name = "certificado", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Certificado.findAll", query = "SELECT c FROM Certificado c")})
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Integer idcliente;
    @Column(name = "validadelicencaatual")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validadelicencaatual;
    @Column(name = "numerocertificado", length = 2147483647)
    private String numerocertificado;
    @Column(name = "tipocertificado", length = 2147483647)
    private String tipocertificado;
    @Column(name = "estadocertificacao")
    private Short estadocertificacao;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;

    public Certificado() {
    }

    public Certificado(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Date getValidadelicencaatual() {
        return validadelicencaatual;
    }

    public void setValidadelicencaatual(Date validadelicencaatual) {
        this.validadelicencaatual = validadelicencaatual;
    }

    public String getNumerocertificado() {
        return numerocertificado;
    }

    public void setNumerocertificado(String numerocertificado) {
        this.numerocertificado = numerocertificado;
    }

    public String getTipocertificado() {
        return tipocertificado;
    }

    public void setTipocertificado(String tipocertificado) {
        this.tipocertificado = tipocertificado;
    }

    public Short getEstadocertificacao() {
        return estadocertificacao;
    }

    public void setEstadocertificacao(Short estadocertificacao) {
        this.estadocertificacao = estadocertificacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        if (!(object instanceof Certificado)) {
            return false;
        }
        Certificado other = (Certificado) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Certificado[ idcliente=" + idcliente + " ]";
    }
    
}
