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
@Table(name = "rpt_legal", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RptLegal.findAll", query = "SELECT r FROM RptLegal r")
    , @NamedQuery(name = "RptLegal.findByRutRptLegal", query = "SELECT r FROM RptLegal r WHERE r.rutRptLegal = :rutRptLegal")
    , @NamedQuery(name = "RptLegal.findByNomRptLegal", query = "SELECT r FROM RptLegal r WHERE r.nomRptLegal = :nomRptLegal")
    , @NamedQuery(name = "RptLegal.findByApellRptLegal", query = "SELECT r FROM RptLegal r WHERE r.apellRptLegal = :apellRptLegal")
    , @NamedQuery(name = "RptLegal.findByCorreoRptLegal", query = "SELECT r FROM RptLegal r WHERE r.correoRptLegal = :correoRptLegal")
    , @NamedQuery(name = "RptLegal.findByEstadoRptLegal", query = "SELECT r FROM RptLegal r WHERE r.estadoRptLegal = :estadoRptLegal")})
public class RptLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rut_rpt_legal", nullable = false, length = 10)
    private String rutRptLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom_rpt_legal", nullable = false, length = 15)
    private String nomRptLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "apell_rpt_legal", nullable = false, length = 15)
    private String apellRptLegal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "correo_rpt_legal", nullable = false, length = 40)
    private String correoRptLegal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_rpt_legal", nullable = false)
    private int estadoRptLegal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutRptLegal")
    private List<RptlegalPerfilEmpresa> rptlegalPerfilEmpresaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutRptLegal")
    private List<FirmaElectronica> firmaElectronicaList;

    public RptLegal() {
    }

    public RptLegal(String rutRptLegal) {
        this.rutRptLegal = rutRptLegal;
    }

    public RptLegal(String rutRptLegal, String nomRptLegal, String apellRptLegal, String correoRptLegal, int estadoRptLegal) {
        this.rutRptLegal = rutRptLegal;
        this.nomRptLegal = nomRptLegal;
        this.apellRptLegal = apellRptLegal;
        this.correoRptLegal = correoRptLegal;
        this.estadoRptLegal = estadoRptLegal;
    }

    public String getRutRptLegal() {
        return rutRptLegal;
    }

    public void setRutRptLegal(String rutRptLegal) {
        this.rutRptLegal = rutRptLegal;
    }

    public String getNomRptLegal() {
        return nomRptLegal;
    }

    public void setNomRptLegal(String nomRptLegal) {
        this.nomRptLegal = nomRptLegal;
    }

    public String getApellRptLegal() {
        return apellRptLegal;
    }

    public void setApellRptLegal(String apellRptLegal) {
        this.apellRptLegal = apellRptLegal;
    }

    public String getCorreoRptLegal() {
        return correoRptLegal;
    }

    public void setCorreoRptLegal(String correoRptLegal) {
        this.correoRptLegal = correoRptLegal;
    }

    public int getEstadoRptLegal() {
        return estadoRptLegal;
    }

    public void setEstadoRptLegal(int estadoRptLegal) {
        this.estadoRptLegal = estadoRptLegal;
    }

    @XmlTransient
    public List<RptlegalPerfilEmpresa> getRptlegalPerfilEmpresaList() {
        return rptlegalPerfilEmpresaList;
    }

    public void setRptlegalPerfilEmpresaList(List<RptlegalPerfilEmpresa> rptlegalPerfilEmpresaList) {
        this.rptlegalPerfilEmpresaList = rptlegalPerfilEmpresaList;
    }

    @XmlTransient
    public List<FirmaElectronica> getFirmaElectronicaList() {
        return firmaElectronicaList;
    }

    public void setFirmaElectronicaList(List<FirmaElectronica> firmaElectronicaList) {
        this.firmaElectronicaList = firmaElectronicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutRptLegal != null ? rutRptLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RptLegal)) {
            return false;
        }
        RptLegal other = (RptLegal) object;
        if ((this.rutRptLegal == null && other.rutRptLegal != null) || (this.rutRptLegal != null && !this.rutRptLegal.equals(other.rutRptLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.RptLegal[ rutRptLegal=" + rutRptLegal + " ]";
    }
    
}
