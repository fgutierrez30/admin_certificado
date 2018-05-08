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
@Table(name = "usr_perfil_empresa", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsrPerfilEmpresa.findAll", query = "SELECT u FROM UsrPerfilEmpresa u")
    , @NamedQuery(name = "UsrPerfilEmpresa.findByIdUsrPerfilEmpresa", query = "SELECT u FROM UsrPerfilEmpresa u WHERE u.idUsrPerfilEmpresa = :idUsrPerfilEmpresa")
    , @NamedQuery(name = "UsrPerfilEmpresa.findByUsrSolicita", query = "SELECT u FROM UsrPerfilEmpresa u WHERE u.usrSolicita = :usrSolicita")
    , @NamedQuery(name = "UsrPerfilEmpresa.findByFechaSolicita", query = "SELECT u FROM UsrPerfilEmpresa u WHERE u.fechaSolicita = :fechaSolicita")})
public class UsrPerfilEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usr_perfil_empresa", nullable = false)
    private Integer idUsrPerfilEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "usr_solicita", nullable = false, length = 70)
    private String usrSolicita;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicita", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSolicita;
    @JoinColumn(name = "rut_usr_cv", referencedColumnName = "rut_usr_cv", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioCv rutUsrCv;
    @JoinColumn(name = "id_perfil", referencedColumnName = "id_perfil", nullable = false)
    @ManyToOne(optional = false)
    private PerfilSii idPerfil;
    @JoinColumn(name = "rut_empresa", referencedColumnName = "rut_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa rutEmpresa;

    public UsrPerfilEmpresa() {
    }

    public UsrPerfilEmpresa(Integer idUsrPerfilEmpresa) {
        this.idUsrPerfilEmpresa = idUsrPerfilEmpresa;
    }

    public UsrPerfilEmpresa(Integer idUsrPerfilEmpresa, String usrSolicita, Date fechaSolicita) {
        this.idUsrPerfilEmpresa = idUsrPerfilEmpresa;
        this.usrSolicita = usrSolicita;
        this.fechaSolicita = fechaSolicita;
    }

    public Integer getIdUsrPerfilEmpresa() {
        return idUsrPerfilEmpresa;
    }

    public void setIdUsrPerfilEmpresa(Integer idUsrPerfilEmpresa) {
        this.idUsrPerfilEmpresa = idUsrPerfilEmpresa;
    }

    public String getUsrSolicita() {
        return usrSolicita;
    }

    public void setUsrSolicita(String usrSolicita) {
        this.usrSolicita = usrSolicita;
    }

    public Date getFechaSolicita() {
        return fechaSolicita;
    }

    public void setFechaSolicita(Date fechaSolicita) {
        this.fechaSolicita = fechaSolicita;
    }

    public UsuarioCv getRutUsrCv() {
        return rutUsrCv;
    }

    public void setRutUsrCv(UsuarioCv rutUsrCv) {
        this.rutUsrCv = rutUsrCv;
    }

    public PerfilSii getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(PerfilSii idPerfil) {
        this.idPerfil = idPerfil;
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
        hash += (idUsrPerfilEmpresa != null ? idUsrPerfilEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsrPerfilEmpresa)) {
            return false;
        }
        UsrPerfilEmpresa other = (UsrPerfilEmpresa) object;
        if ((this.idUsrPerfilEmpresa == null && other.idUsrPerfilEmpresa != null) || (this.idUsrPerfilEmpresa != null && !this.idUsrPerfilEmpresa.equals(other.idUsrPerfilEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.UsrPerfilEmpresa[ idUsrPerfilEmpresa=" + idUsrPerfilEmpresa + " ]";
    }
    
}
