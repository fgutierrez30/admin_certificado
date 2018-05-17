/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fgutierrez
 */
@Entity
@Table(name = "empresa", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findByHolding", query = "SELECT e FROM Empresa e WHERE e.idHolding.idHolding = :id_holding")
    ,@NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByRutEmpresa", query = "SELECT e FROM Empresa e WHERE e.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "Empresa.findByRazonSocial", query = "SELECT e FROM Empresa e WHERE e.razonSocial = :razonSocial")
    , @NamedQuery(name = "Empresa.findByEstadoEmp", query = "SELECT e FROM Empresa e WHERE e.estadoEmp = :estadoEmp")
    , @NamedQuery(name = "Empresa.findByMailContacto", query = "SELECT e FROM Empresa e WHERE e.mailContacto = :mailContacto")
    , @NamedQuery(name = "Empresa.findByMailSii", query = "SELECT e FROM Empresa e WHERE e.mailSii = :mailSii")
    , @NamedQuery(name = "Empresa.findByMailAdm", query = "SELECT e FROM Empresa e WHERE e.mailAdm = :mailAdm")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rut_empresa", nullable = false, length = 10)
    private String rutEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "razon_social", nullable = false, length = 100)
    private String razonSocial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_emp", nullable = false)
    private int estadoEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "mail_contacto", nullable = false, length = 80)
    private String mailContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "mail_sii", nullable = false, length = 80)
    private String mailSii;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "mail_adm", nullable = false, length = 80)
    private String mailAdm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutEmpresa")
    private List<RptlegalPerfilEmpresa> rptlegalPerfilEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutEmpresa")
    private List<UsrPerfilEmpresa> usrPerfilEmpresaList;
    @JoinColumn(name = "id_holding", referencedColumnName = "id_holding", nullable = false)
    @ManyToOne(optional = false)
    private Holding idHolding;

    public Empresa() {
    }

    public Empresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public Empresa(String rutEmpresa, String razonSocial, int estadoEmp, String mailContacto, String mailSii, String mailAdm) {
        this.rutEmpresa = rutEmpresa;
        this.razonSocial = razonSocial;
        this.estadoEmp = estadoEmp;
        this.mailContacto = mailContacto;
        this.mailSii = mailSii;
        this.mailAdm = mailAdm;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(int estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getMailContacto() {
        return mailContacto;
    }

    public void setMailContacto(String mailContacto) {
        this.mailContacto = mailContacto;
    }

    public String getMailSii() {
        return mailSii;
    }

    public void setMailSii(String mailSii) {
        this.mailSii = mailSii;
    }

    public String getMailAdm() {
        return mailAdm;
    }

    public void setMailAdm(String mailAdm) {
        this.mailAdm = mailAdm;
    }

    @XmlTransient
    public List<RptlegalPerfilEmpresa> getRptlegalPerfilEmpresaList() {
        return rptlegalPerfilEmpresaList;
    }

    public void setRptlegalPerfilEmpresaList(List<RptlegalPerfilEmpresa> rptlegalPerfilEmpresaList) {
        this.rptlegalPerfilEmpresaList = rptlegalPerfilEmpresaList;
    }

    @XmlTransient
    public List<UsrPerfilEmpresa> getUsrPerfilEmpresaList() {
        return usrPerfilEmpresaList;
    }

    public void setUsrPerfilEmpresaList(List<UsrPerfilEmpresa> usrPerfilEmpresaList) {
        this.usrPerfilEmpresaList = usrPerfilEmpresaList;
    }

    public Holding getIdHolding() {
        return idHolding;
    }

    public void setIdHolding(Holding idHolding) {
        this.idHolding = idHolding;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutEmpresa != null ? rutEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.rutEmpresa == null && other.rutEmpresa != null) || (this.rutEmpresa != null && !this.rutEmpresa.equals(other.rutEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.Empresa[ rutEmpresa=" + rutEmpresa + " ]";
    }
    
}
