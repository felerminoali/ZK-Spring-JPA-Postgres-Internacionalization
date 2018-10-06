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
@Table(name = "endereco", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Long idcliente;
    @Column(name = "bairro", length = 2147483647)
    private String bairro;
    @Column(name = "linhadeendereco1", length = 2147483647)
    private String linhadeendereco1;
    @Column(name = "linhadeendereco2", length = 2147483647)
    private String linhadeendereco2;
    @Column(name = "codigopostal", length = 2147483647)
    private String codigopostal;
    @JoinColumn(name = "cidade", referencedColumnName = "idcidade", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cidade cidade;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "pais", referencedColumnName = "idpais", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais pais;
    @JoinColumn(name = "postoadministrativo", referencedColumnName = "idpostoadministrativo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Postoadministrativo postoadministrativo;
    @JoinColumn(name = "provincia", referencedColumnName = "idprovincia", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Provincia provincia;

    public Endereco() {
    }

    public Endereco(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLinhadeendereco1() {
        return linhadeendereco1;
    }

    public void setLinhadeendereco1(String linhadeendereco1) {
        this.linhadeendereco1 = linhadeendereco1;
    }

    public String getLinhadeendereco2() {
        return linhadeendereco2;
    }

    public void setLinhadeendereco2(String linhadeendereco2) {
        this.linhadeendereco2 = linhadeendereco2;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Postoadministrativo getPostoadministrativo() {
        return postoadministrativo;
    }

    public void setPostoadministrativo(Postoadministrativo postoadministrativo) {
        this.postoadministrativo = postoadministrativo;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
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
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Endereco[ idcliente=" + idcliente + " ]";
    }
    
}
