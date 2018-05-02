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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgutierrez
 */
@Entity
@Table(name = "perfil_sii_rpt_legal", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilSiiRptLegal.findAll", query = "SELECT p FROM PerfilSiiRptLegal p")
    , @NamedQuery(name = "PerfilSiiRptLegal.findByIdPerfilSiiRptLegal", query = "SELECT p FROM PerfilSiiRptLegal p WHERE p.idPerfilSiiRptLegal = :idPerfilSiiRptLegal")})
public class PerfilSiiRptLegal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil_sii_rpt_legal", nullable = false)
    private Integer idPerfilSiiRptLegal;
    @JoinColumn(name = "rut", referencedColumnName = "rut_rpt_legal", nullable = false)
    @ManyToOne(optional = false)
    private Representante rut;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private PerfilSii idPerfil;

    public PerfilSiiRptLegal() {
    }

    public PerfilSiiRptLegal(Integer idPerfilSiiRptLegal) {
        this.idPerfilSiiRptLegal = idPerfilSiiRptLegal;
    }

    public Integer getIdPerfilSiiRptLegal() {
        return idPerfilSiiRptLegal;
    }

    public void setIdPerfilSiiRptLegal(Integer idPerfilSiiRptLegal) {
        this.idPerfilSiiRptLegal = idPerfilSiiRptLegal;
    }

    public Representante getRut() {
        return rut;
    }

    public void setRut(Representante rut) {
        this.rut = rut;
    }

    public PerfilSii getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(PerfilSii idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilSiiRptLegal != null ? idPerfilSiiRptLegal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilSiiRptLegal)) {
            return false;
        }
        PerfilSiiRptLegal other = (PerfilSiiRptLegal) object;
        if ((this.idPerfilSiiRptLegal == null && other.idPerfilSiiRptLegal != null) || (this.idPerfilSiiRptLegal != null && !this.idPerfilSiiRptLegal.equals(other.idPerfilSiiRptLegal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.PerfilSiiRptLegal[ idPerfilSiiRptLegal=" + idPerfilSiiRptLegal + " ]";
    }
    
}
