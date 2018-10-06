/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package municipio.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "cliente", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Long idcliente;
    @Column(name = "contanome", length = 2147483647)
    private String contanome;
    @Column(name = "nuit", length = 2147483647)
    private String nuit;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Clientesingular clientesingular;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Clienteorganizacao clienteorganizacao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Dadoscontacto dadoscontacto;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    private Certificado certificado;
    @JoinColumn(name = "tipoentidade", referencedColumnName = "idtipoentidade", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipoentidade tipoentidade;

    public Cliente() {
    }

    public Cliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getContanome() {
        return contanome;
    }

    public void setContanome(String contanome) {
        this.contanome = contanome;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Clientesingular getClientesingular() {
        return clientesingular;
    }

    public void setClientesingular(Clientesingular clientesingular) {
        this.clientesingular = clientesingular;
    }

    public Clienteorganizacao getClienteorganizacao() {
        return clienteorganizacao;
    }

    public void setClienteorganizacao(Clienteorganizacao clienteorganizacao) {
        this.clienteorganizacao = clienteorganizacao;
    }

    public Dadoscontacto getDadoscontacto() {
        return dadoscontacto;
    }

    public void setDadoscontacto(Dadoscontacto dadoscontacto) {
        this.dadoscontacto = dadoscontacto;
    }

    public Certificado getCertificado() {
        return certificado;
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }

    public Tipoentidade getTipoentidade() {
        return tipoentidade;
    }

    public void setTipoentidade(Tipoentidade tipoentidade) {
        this.tipoentidade = tipoentidade;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
