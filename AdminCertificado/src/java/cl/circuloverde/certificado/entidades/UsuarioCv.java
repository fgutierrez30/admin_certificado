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
@Table(name = "usuario_cv", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioCv.findAll", query = "SELECT u FROM UsuarioCv u")
    , @NamedQuery(name = "UsuarioCv.findByRutUsrCv", query = "SELECT u FROM UsuarioCv u WHERE u.rutUsrCv = :rutUsrCv")
    , @NamedQuery(name = "UsuarioCv.findByNomUsrCv", query = "SELECT u FROM UsuarioCv u WHERE u.nomUsrCv = :nomUsrCv")
    , @NamedQuery(name = "UsuarioCv.findByApellUsrCv", query = "SELECT u FROM UsuarioCv u WHERE u.apellUsrCv = :apellUsrCv")
    , @NamedQuery(name = "UsuarioCv.findByEstadoUsrCv", query = "SELECT u FROM UsuarioCv u WHERE u.estadoUsrCv = :estadoUsrCv")})
public class UsuarioCv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "rut_usr_cv", nullable = false, length = 10)
    private String rutUsrCv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom_usr_cv", nullable = false, length = 15)
    private String nomUsrCv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "apell_usr_cv", nullable = false, length = 15)
    private String apellUsrCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usr_cv", nullable = false)
    private int estadoUsrCv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsrCv")
    private List<EmpresaUsuarioCv> empresaUsuarioCvList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutUsrCv")
    private List<PerfilSiiUsrCv> perfilSiiUsrCvList;

    public UsuarioCv() {
    }

    public UsuarioCv(String rutUsrCv) {
        this.rutUsrCv = rutUsrCv;
    }

    public UsuarioCv(String rutUsrCv, String nomUsrCv, String apellUsrCv, int estadoUsrCv) {
        this.rutUsrCv = rutUsrCv;
        this.nomUsrCv = nomUsrCv;
        this.apellUsrCv = apellUsrCv;
        this.estadoUsrCv = estadoUsrCv;
    }

    public String getRutUsrCv() {
        return rutUsrCv;
    }

    public void setRutUsrCv(String rutUsrCv) {
        this.rutUsrCv = rutUsrCv;
    }

    public String getNomUsrCv() {
        return nomUsrCv;
    }

    public void setNomUsrCv(String nomUsrCv) {
        this.nomUsrCv = nomUsrCv;
    }

    public String getApellUsrCv() {
        return apellUsrCv;
    }

    public void setApellUsrCv(String apellUsrCv) {
        this.apellUsrCv = apellUsrCv;
    }

    public int getEstadoUsrCv() {
        return estadoUsrCv;
    }

    public void setEstadoUsrCv(int estadoUsrCv) {
        this.estadoUsrCv = estadoUsrCv;
    }

    @XmlTransient
    public List<EmpresaUsuarioCv> getEmpresaUsuarioCvList() {
        return empresaUsuarioCvList;
    }

    public void setEmpresaUsuarioCvList(List<EmpresaUsuarioCv> empresaUsuarioCvList) {
        this.empresaUsuarioCvList = empresaUsuarioCvList;
    }

    @XmlTransient
    public List<PerfilSiiUsrCv> getPerfilSiiUsrCvList() {
        return perfilSiiUsrCvList;
    }

    public void setPerfilSiiUsrCvList(List<PerfilSiiUsrCv> perfilSiiUsrCvList) {
        this.perfilSiiUsrCvList = perfilSiiUsrCvList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutUsrCv != null ? rutUsrCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioCv)) {
            return false;
        }
        UsuarioCv other = (UsuarioCv) object;
        if ((this.rutUsrCv == null && other.rutUsrCv != null) || (this.rutUsrCv != null && !this.rutUsrCv.equals(other.rutUsrCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.UsuarioCv[ rutUsrCv=" + rutUsrCv + " ]";
    }
    
}
