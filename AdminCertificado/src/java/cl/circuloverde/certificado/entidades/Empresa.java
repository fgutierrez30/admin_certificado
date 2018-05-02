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
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e")
    , @NamedQuery(name = "Empresa.findByRutEmpresa", query = "SELECT e FROM Empresa e WHERE e.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "Empresa.findByRazonSocial", query = "SELECT e FROM Empresa e WHERE e.razonSocial = :razonSocial")
    , @NamedQuery(name = "Empresa.findByRutRptLegal", query = "SELECT e FROM Empresa e WHERE e.rutRptLegal = :rutRptLegal")
    , @NamedQuery(name = "Empresa.findByEstadoEmp", query = "SELECT e FROM Empresa e WHERE e.estadoEmp = :estadoEmp")
    , @NamedQuery(name = "Empresa.findByCorreoContacto", query = "SELECT e FROM Empresa e WHERE e.correoContacto = :correoContacto")
    , @NamedQuery(name = "Empresa.findByCorreoSii", query = "SELECT e FROM Empresa e WHERE e.correoSii = :correoSii")
    , @NamedQuery(name = "Empresa.findByCorreoAdmin", query = "SELECT e FROM Empresa e WHERE e.correoAdmin = :correoAdmin")})
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
    @Size(min = 1, max = 10)
    @Column(name = "rut_rpt_legal", nullable = false, length = 10)
    private String rutRptLegal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_emp", nullable = false)
    private int estadoEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "correo_contacto", nullable = false, length = 80)
    private String correoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "correo_sii", nullable = false, length = 80)
    private String correoSii;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "correo_admin", nullable = false, length = 80)
    private String correoAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutEmpresa")
    private List<EmpresaUsuarioCv> empresaUsuarioCvList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutEmpresa")
    private List<RptLegalEmpresa> rptLegalEmpresaList;
    @JoinColumn(name = "id_holding", referencedColumnName = "id_holding", nullable = false)
    @ManyToOne(optional = false)
    private Holding idHolding;

    public Empresa() {
    }

    public Empresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public Empresa(String rutEmpresa, String razonSocial, String rutRptLegal, int estadoEmp, String correoContacto, String correoSii, String correoAdmin) {
        this.rutEmpresa = rutEmpresa;
        this.razonSocial = razonSocial;
        this.rutRptLegal = rutRptLegal;
        this.estadoEmp = estadoEmp;
        this.correoContacto = correoContacto;
        this.correoSii = correoSii;
        this.correoAdmin = correoAdmin;
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

    public String getRutRptLegal() {
        return rutRptLegal;
    }

    public void setRutRptLegal(String rutRptLegal) {
        this.rutRptLegal = rutRptLegal;
    }

    public int getEstadoEmp() {
        return estadoEmp;
    }

    public void setEstadoEmp(int estadoEmp) {
        this.estadoEmp = estadoEmp;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getCorreoSii() {
        return correoSii;
    }

    public void setCorreoSii(String correoSii) {
        this.correoSii = correoSii;
    }

    public String getCorreoAdmin() {
        return correoAdmin;
    }

    public void setCorreoAdmin(String correoAdmin) {
        this.correoAdmin = correoAdmin;
    }

    @XmlTransient
    public List<EmpresaUsuarioCv> getEmpresaUsuarioCvList() {
        return empresaUsuarioCvList;
    }

    public void setEmpresaUsuarioCvList(List<EmpresaUsuarioCv> empresaUsuarioCvList) {
        this.empresaUsuarioCvList = empresaUsuarioCvList;
    }

    @XmlTransient
    public List<RptLegalEmpresa> getRptLegalEmpresaList() {
        return rptLegalEmpresaList;
    }

    public void setRptLegalEmpresaList(List<RptLegalEmpresa> rptLegalEmpresaList) {
        this.rptLegalEmpresaList = rptLegalEmpresaList;
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
