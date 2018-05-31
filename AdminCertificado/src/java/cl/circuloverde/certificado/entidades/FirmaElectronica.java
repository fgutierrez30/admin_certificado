/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.circuloverde.certificado.entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgutierrez
 */
@Entity
@Table(name = "firma_electronica", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FirmaElectronica.findByRut", query = "SELECT f FROM FirmaElectronica f WHERE f.rutRptLegal.rutRptLegal = :rutRpt")
    ,@NamedQuery(name = "FirmaElectronica.findAll", query = "SELECT f FROM FirmaElectronica f")
    , @NamedQuery(name = "FirmaElectronica.findByIdFirma", query = "SELECT f FROM FirmaElectronica f WHERE f.idFirma = :idFirma")
    , @NamedQuery(name = "FirmaElectronica.findByFechaCompra", query = "SELECT f FROM FirmaElectronica f WHERE f.fechaCompra = :fechaCompra")
    , @NamedQuery(name = "FirmaElectronica.findByFechaVcto", query = "SELECT f FROM FirmaElectronica f WHERE f.fechaVcto = :fechaVcto")
    , @NamedQuery(name = "FirmaElectronica.findByClaveInstalacion", query = "SELECT f FROM FirmaElectronica f WHERE f.claveInstalacion = :claveInstalacion")
    , @NamedQuery(name = "FirmaElectronica.findByEstadoFirma", query = "SELECT f FROM FirmaElectronica f WHERE f.estadoFirma = :estadoFirma")})
public class FirmaElectronica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_firma", nullable = false)
    private Integer idFirma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vcto", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVcto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "clave_instalacion", nullable = false, length = 20)
    private String claveInstalacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_firma", nullable = false)
    private int estadoFirma;
    @JoinColumn(name = "rut_rpt_legal", referencedColumnName = "rut_rpt_legal", nullable = false)
    @ManyToOne(optional = false)
    private RptLegal rutRptLegal;

    public FirmaElectronica() {
    }

    public FirmaElectronica(Integer idFirma) {
        this.idFirma = idFirma;
    }

    public FirmaElectronica(Integer idFirma, Date fechaCompra, Date fechaVcto, String claveInstalacion, int estadoFirma) {
        this.idFirma = idFirma;
        this.fechaCompra = fechaCompra;
        this.fechaVcto = fechaVcto;
        this.claveInstalacion = claveInstalacion;
        this.estadoFirma = estadoFirma;
    }

    public Integer getIdFirma() {
        return idFirma;
    }

    public void setIdFirma(Integer idFirma) {
        this.idFirma = idFirma;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getFechaVcto() {
        return fechaVcto;
    }

    public void setFechaVcto(Date fechaVcto) {
        this.fechaVcto = fechaVcto;
    }

    public String getClaveInstalacion() {
        return claveInstalacion;
    }

    public void setClaveInstalacion(String claveInstalacion) {
        this.claveInstalacion = claveInstalacion;
    }

    public int getEstadoFirma() {
        return estadoFirma;
    }

    public void setEstadoFirma(int estadoFirma) {
        this.estadoFirma = estadoFirma;
    }

    public RptLegal getRutRptLegal() {
        return rutRptLegal;
    }

    public void setRutRptLegal(RptLegal rutRptLegal) {
        this.rutRptLegal = rutRptLegal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFirma != null ? idFirma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmaElectronica)) {
            return false;
        }
        FirmaElectronica other = (FirmaElectronica) object;
        if ((this.idFirma == null && other.idFirma != null) || (this.idFirma != null && !this.idFirma.equals(other.idFirma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.FirmaElectronica[ idFirma=" + idFirma + " ]";
    }
    
}
