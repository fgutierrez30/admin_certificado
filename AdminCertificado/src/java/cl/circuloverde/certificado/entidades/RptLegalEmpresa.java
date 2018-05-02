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
@Table(name = "rpt_legal_empresa", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RptLegalEmpresa.findAll", query = "SELECT r FROM RptLegalEmpresa r")
    , @NamedQuery(name = "RptLegalEmpresa.findByIdRptLegalEmpresa", query = "SELECT r FROM RptLegalEmpresa r WHERE r.idRptLegalEmpresa = :idRptLegalEmpresa")
    , @NamedQuery(name = "RptLegalEmpresa.findByEstadoRptLegalEmpresa", query = "SELECT r FROM RptLegalEmpresa r WHERE r.estadoRptLegalEmpresa = :estadoRptLegalEmpresa")})
public class RptLegalEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rpt_legal_empresa", nullable = false)
    private Integer idRptLegalEmpresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_rpt_legal_empresa", nullable = false)
    private int estadoRptLegalEmpresa;
    @JoinColumn(name = "rut_rpt_legal", referencedColumnName = "rut_rpt_legal", nullable = false)
    @ManyToOne(optional = false)
    private Representante rutRptLegal;
    @JoinColumn(name = "rut_empresa", referencedColumnName = "rut_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa rutEmpresa;

    public RptLegalEmpresa() {
    }

    public RptLegalEmpresa(Integer idRptLegalEmpresa) {
        this.idRptLegalEmpresa = idRptLegalEmpresa;
    }

    public RptLegalEmpresa(Integer idRptLegalEmpresa, int estadoRptLegalEmpresa) {
        this.idRptLegalEmpresa = idRptLegalEmpresa;
        this.estadoRptLegalEmpresa = estadoRptLegalEmpresa;
    }

    public Integer getIdRptLegalEmpresa() {
        return idRptLegalEmpresa;
    }

    public void setIdRptLegalEmpresa(Integer idRptLegalEmpresa) {
        this.idRptLegalEmpresa = idRptLegalEmpresa;
    }

    public int getEstadoRptLegalEmpresa() {
        return estadoRptLegalEmpresa;
    }

    public void setEstadoRptLegalEmpresa(int estadoRptLegalEmpresa) {
        this.estadoRptLegalEmpresa = estadoRptLegalEmpresa;
    }

    public Representante getRutRptLegal() {
        return rutRptLegal;
    }

    public void setRutRptLegal(Representante rutRptLegal) {
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
        hash += (idRptLegalEmpresa != null ? idRptLegalEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RptLegalEmpresa)) {
            return false;
        }
        RptLegalEmpresa other = (RptLegalEmpresa) object;
        if ((this.idRptLegalEmpresa == null && other.idRptLegalEmpresa != null) || (this.idRptLegalEmpresa != null && !this.idRptLegalEmpresa.equals(other.idRptLegalEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.RptLegalEmpresa[ idRptLegalEmpresa=" + idRptLegalEmpresa + " ]";
    }
    
}
