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
@Table(name = "perfil_sii_usr_cv", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilSiiUsrCv.findAll", query = "SELECT p FROM PerfilSiiUsrCv p")
    , @NamedQuery(name = "PerfilSiiUsrCv.findByIdPerfilSiiUsrCv", query = "SELECT p FROM PerfilSiiUsrCv p WHERE p.idPerfilSiiUsrCv = :idPerfilSiiUsrCv")})
public class PerfilSiiUsrCv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil_sii_usr_cv", nullable = false)
    private Integer idPerfilSiiUsrCv;
    @JoinColumn(name = "id_tpo_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private PerfilSii idTpoPerfil;
    @JoinColumn(name = "rut_usr_cv", referencedColumnName = "rut_usr_cv", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioCv rutUsrCv;

    public PerfilSiiUsrCv() {
    }

    public PerfilSiiUsrCv(Integer idPerfilSiiUsrCv) {
        this.idPerfilSiiUsrCv = idPerfilSiiUsrCv;
    }

    public Integer getIdPerfilSiiUsrCv() {
        return idPerfilSiiUsrCv;
    }

    public void setIdPerfilSiiUsrCv(Integer idPerfilSiiUsrCv) {
        this.idPerfilSiiUsrCv = idPerfilSiiUsrCv;
    }

    public PerfilSii getIdTpoPerfil() {
        return idTpoPerfil;
    }

    public void setIdTpoPerfil(PerfilSii idTpoPerfil) {
        this.idTpoPerfil = idTpoPerfil;
    }

    public UsuarioCv getRutUsrCv() {
        return rutUsrCv;
    }

    public void setRutUsrCv(UsuarioCv rutUsrCv) {
        this.rutUsrCv = rutUsrCv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfilSiiUsrCv != null ? idPerfilSiiUsrCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilSiiUsrCv)) {
            return false;
        }
        PerfilSiiUsrCv other = (PerfilSiiUsrCv) object;
        if ((this.idPerfilSiiUsrCv == null && other.idPerfilSiiUsrCv != null) || (this.idPerfilSiiUsrCv != null && !this.idPerfilSiiUsrCv.equals(other.idPerfilSiiUsrCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.PerfilSiiUsrCv[ idPerfilSiiUsrCv=" + idPerfilSiiUsrCv + " ]";
    }
    
}
