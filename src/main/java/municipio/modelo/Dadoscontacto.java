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
@Table(name = "dadoscontacto", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Dadoscontacto.findAll", query = "SELECT d FROM Dadoscontacto d")})
public class Dadoscontacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Long idcliente;
    @Column(name = "cnome", length = 2147483647)
    private String cnome;
    @Column(name = "capelido", length = 2147483647)
    private String capelido;
    @Basic(optional = false)
    @Column(name = "nrtelemovel", nullable = false, length = 2147483647)
    private String nrtelemovel;
    @Column(name = "email", length = 2147483647)
    private String email;
    @Column(name = "nrcontactoalternativo", length = 2147483647)
    private String nrcontactoalternativo;
    @Basic(optional = false)
    @Column(name = "relacaotitulardaconta", nullable = false, length = 2147483647)
    private String relacaotitulardaconta;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "metodocontactopreferido", referencedColumnName = "idmetodocontacto", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Metodocontacto metodocontactopreferido;
    @JoinColumn(name = "metodocontactoadicional", referencedColumnName = "idmetodocontactoadicional", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Metodocontactoadicional metodocontactoadicional;
    @JoinColumn(name = "tipocontacto", referencedColumnName = "idtipocontacto", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipocontacto tipocontacto;

    public Dadoscontacto() {
    }

    public Dadoscontacto(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Dadoscontacto(Long idcliente, String nrtelemovel, String relacaotitulardaconta) {
        this.idcliente = idcliente;
        this.nrtelemovel = nrtelemovel;
        this.relacaotitulardaconta = relacaotitulardaconta;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getCnome() {
        return cnome;
    }

    public void setCnome(String cnome) {
        this.cnome = cnome;
    }

    public String getCapelido() {
        return capelido;
    }

    public void setCapelido(String capelido) {
        this.capelido = capelido;
    }

    public String getNrtelemovel() {
        return nrtelemovel;
    }

    public void setNrtelemovel(String nrtelemovel) {
        this.nrtelemovel = nrtelemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrcontactoalternativo() {
        return nrcontactoalternativo;
    }

    public void setNrcontactoalternativo(String nrcontactoalternativo) {
        this.nrcontactoalternativo = nrcontactoalternativo;
    }

    public String getRelacaotitulardaconta() {
        return relacaotitulardaconta;
    }

    public void setRelacaotitulardaconta(String relacaotitulardaconta) {
        this.relacaotitulardaconta = relacaotitulardaconta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Metodocontacto getMetodocontactopreferido() {
        return metodocontactopreferido;
    }

    public void setMetodocontactopreferido(Metodocontacto metodocontactopreferido) {
        this.metodocontactopreferido = metodocontactopreferido;
    }

    public Metodocontactoadicional getMetodocontactoadicional() {
        return metodocontactoadicional;
    }

    public void setMetodocontactoadicional(Metodocontactoadicional metodocontactoadicional) {
        this.metodocontactoadicional = metodocontactoadicional;
    }

    public Tipocontacto getTipocontacto() {
        return tipocontacto;
    }

    public void setTipocontacto(Tipocontacto tipocontacto) {
        this.tipocontacto = tipocontacto;
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
        if (!(object instanceof Dadoscontacto)) {
            return false;
        }
        Dadoscontacto other = (Dadoscontacto) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Dadoscontacto[ idcliente=" + idcliente + " ]";
    }
    
}
