/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgutierrez
 */
@Entity
@Table(name = "rptlegal_perfil_empresa", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RptlegalPerfilEmpresa.empXrptPermisos", query = "SELECT r FROM RptlegalPerfilEmpresa r where r.rutRptLegal.rutRptLegal =:rutRpt")
    ,@NamedQuery(name = "RptlegalPerfilEmpresa.empXrpt", query = "SELECT r FROM RptlegalPerfilEmpresa r where r.rutRptLegal.rutRptLegal =:rutRpt GROUP BY R.rutEmpresa.rutEmpresa")
    ,@NamedQuery(name = "RptlegalPerfilEmpresa.permisos", query = "SELECT r FROM RptlegalPerfilEmpresa r where r.rutEmpresa.rutEmpresa =:rutEmp")
    ,@NamedQuery(name = "RptlegalPerfilEmpresa.rptXemp", query = "SELECT r FROM RptlegalPerfilEmpresa r where r.rutEmpresa.rutEmpresa =:rutEmp GROUP BY R.rutRptLegal.rutRptLegal")
    , @NamedQuery(name = "RptlegalPerfilEmpresa.findAll", query = "SELECT r FROM RptlegalPerfilEmpresa r")
    , @NamedQuery(name = "RptlegalPerfilEmpresa.findByIdrptLegalperfilempresa", query = "SELECT r FROM RptlegalPerfilEmpresa r WHERE r.idrptLegalperfilempresa = :idrptLegalperfilempresa")
    , @NamedQuery(name = "RptlegalPerfilEmpresa.findByEstadoAsigna", query = "SELECT r FROM RptlegalPerfilEmpresa r WHERE r.estadoAsigna = :estadoAsigna")})
public class RptlegalPerfilEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rptLegal_perfil_empresa", nullable = false)
    private Integer idrptLegalperfilempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_asigna", nullable = false)
    private int estadoAsigna;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private PerfilSii idPerfil;
    @JoinColumn(name = "rut_rpt_legal", referencedColumnName = "rut_rpt_legal", nullable = false)
    @ManyToOne(optional = false)
    private RptLegal rutRptLegal;
    @JoinColumn(name = "rut_empresa", referencedColumnName = "rut_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa rutEmpresa;

    public RptlegalPerfilEmpresa() {
    }

    public RptlegalPerfilEmpresa(Integer idrptLegalperfilempresa) {
        this.idrptLegalperfilempresa = idrptLegalperfilempresa;
    }

    public RptlegalPerfilEmpresa(Integer idrptLegalperfilempresa, int estadoAsigna) {
        this.idrptLegalperfilempresa = idrptLegalperfilempresa;
        this.estadoAsigna = estadoAsigna;
    }

    public Integer getIdrptLegalperfilempresa() {
        return idrptLegalperfilempresa;
    }

    public void setIdrptLegalperfilempresa(Integer idrptLegalperfilempresa) {
        this.idrptLegalperfilempresa = idrptLegalperfilempresa;
    }

    public int getEstadoAsigna() {
        return estadoAsigna;
    }

    public void setEstadoAsigna(int estadoAsigna) {
        this.estadoAsigna = estadoAsigna;
    }

    public PerfilSii getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(PerfilSii idPerfil) {
        this.idPerfil = idPerfil;
    }

    public RptLegal getRutRptLegal() {
        return rutRptLegal;
    }

    public void setRutRptLegal(RptLegal rutRptLegal) {
        this.rutRptLegal = rutRptLegal;
    }

    public Empresa getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(Empresa rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrptLegalperfilempresa != null ? idrptLegalperfilempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RptlegalPerfilEmpresa)) {
            return false;
        }
        RptlegalPerfilEmpresa other = (RptlegalPerfilEmpresa) object;
        if ((this.idrptLegalperfilempresa == null && other.idrptLegalperfilempresa != null) || (this.idrptLegalperfilempresa != null && !this.idrptLegalperfilempresa.equals(other.idrptLegalperfilempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.RptlegalPerfilEmpresa[ idrptLegalperfilempresa=" + idrptLegalperfilempresa + " ]";
    }
    
}
