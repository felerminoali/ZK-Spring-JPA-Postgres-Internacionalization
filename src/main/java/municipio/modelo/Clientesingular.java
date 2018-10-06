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
import javax.persistence.ManyToOne;
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
@Table(name = "clientesingular", catalog = "municipio", schema = "municipio")
@NamedQueries({
    @NamedQuery(name = "Clientesingular.findAll", query = "SELECT c FROM Clientesingular c")})
public class Clientesingular implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente", nullable = false)
    private Long idcliente;
    @Column(name = "nome", length = 2147483647)
    private String nome;
    @Basic(optional = false)
    @Column(name = "apelido", nullable = false, length = 2147483647)
    private String apelido;
    @Column(name = "datanascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datanascimento;
    @Column(name = "outrotipodocumento", length = 2147483647)
    private String outrotipodocumento;
    @Column(name = "nridentificacao", length = 2147483647)
    private String nridentificacao;
    @Basic(optional = false)
    @Column(name = "agregadofamiliar", nullable = false)
    private int agregadofamiliar;
    @Column(name = "isentodeipa")
    private Boolean isentodeipa;
    @Column(name = "motivodeisencao", length = 2147483647)
    private String motivodeisencao;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "estadoclivil", referencedColumnName = "idestadocivil", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Estadocivil estadoclivil;
    @JoinColumn(name = "cidadania", referencedColumnName = "idpais", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais cidadania;
    @JoinColumn(name = "nacionalidade", referencedColumnName = "idpais", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais nacionalidade;
    @JoinColumn(name = "paisemissao", referencedColumnName = "idpais", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pais paisemissao;
    @JoinColumn(name = "sexo", referencedColumnName = "idsexo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sexo sexo;
    @JoinColumn(name = "tipoidentificacao", referencedColumnName = "idtipoidentificacao", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipoidentificacao tipoidentificacao;

    public Clientesingular() {
    }

    public Clientesingular(Long idcliente) {
        this.idcliente = idcliente;
    }

    public Clientesingular(Long idcliente, String apelido, int agregadofamiliar) {
        this.idcliente = idcliente;
        this.apelido = apelido;
        this.agregadofamiliar = agregadofamiliar;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getOutrotipodocumento() {
        return outrotipodocumento;
    }

    public void setOutrotipodocumento(String outrotipodocumento) {
        this.outrotipodocumento = outrotipodocumento;
    }

    public String getNridentificacao() {
        return nridentificacao;
    }

    public void setNridentificacao(String nridentificacao) {
        this.nridentificacao = nridentificacao;
    }

    public int getAgregadofamiliar() {
        return agregadofamiliar;
    }

    public void setAgregadofamiliar(int agregadofamiliar) {
        this.agregadofamiliar = agregadofamiliar;
    }

    public Boolean getIsentodeipa() {
        return isentodeipa;
    }

    public void setIsentodeipa(Boolean isentodeipa) {
        this.isentodeipa = isentodeipa;
    }

    public String getMotivodeisencao() {
        return motivodeisencao;
    }

    public void setMotivodeisencao(String motivodeisencao) {
        this.motivodeisencao = motivodeisencao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estadocivil getEstadoclivil() {
        return estadoclivil;
    }

    public void setEstadoclivil(Estadocivil estadoclivil) {
        this.estadoclivil = estadoclivil;
    }

    public Pais getCidadania() {
        return cidadania;
    }

    public void setCidadania(Pais cidadania) {
        this.cidadania = cidadania;
    }

    public Pais getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(Pais nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Pais getPaisemissao() {
        return paisemissao;
    }

    public void setPaisemissao(Pais paisemissao) {
        this.paisemissao = paisemissao;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Tipoidentificacao getTipoidentificacao() {
        return tipoidentificacao;
    }

    public void setTipoidentificacao(Tipoidentificacao tipoidentificacao) {
        this.tipoidentificacao = tipoidentificacao;
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
        if (!(object instanceof Clientesingular)) {
            return false;
        }
        Clientesingular other = (Clientesingular) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "intel.Clientesingular[ idcliente=" + idcliente + " ]";
    }
    
}
