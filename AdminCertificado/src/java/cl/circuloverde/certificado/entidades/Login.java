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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fgutierrez
 */
@Entity
@Table(name = "login", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
      @NamedQuery(name = "Login.findByUsrClave", query = "SELECT l FROM Login l WHERE l.usrname= :usr AND l.clave= :clave")
    , @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
    , @NamedQuery(name = "Login.findByIdLogin", query = "SELECT l FROM Login l WHERE l.idLogin = :idLogin")
    , @NamedQuery(name = "Login.findByUsrname", query = "SELECT l FROM Login l WHERE l.usrname = :usrname")
    , @NamedQuery(name = "Login.findByClave", query = "SELECT l FROM Login l WHERE l.clave = :clave")
    , @NamedQuery(name = "Login.findByEstadoLogin", query = "SELECT l FROM Login l WHERE l.estadoLogin = :estadoLogin")
    , @NamedQuery(name = "Login.findByNomCompleto", query = "SELECT l FROM Login l WHERE l.nomCompleto = :nomCompleto")})
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_login", nullable = false)
    private Integer idLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "usrname", nullable = false, length = 15)
    private String usrname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "clave", nullable = false, length = 10)
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_login", nullable = false)
    private int estadoLogin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_completo", nullable = false, length = 50)
    private String nomCompleto;

    public Login() {
    }

    public Login(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Login(Integer idLogin, String usrname, String clave, int estadoLogin, String nomCompleto) {
        this.idLogin = idLogin;
        this.usrname = usrname;
        this.clave = clave;
        this.estadoLogin = estadoLogin;
        this.nomCompleto = nomCompleto;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstadoLogin() {
        return estadoLogin;
    }

    public void setEstadoLogin(int estadoLogin) {
        this.estadoLogin = estadoLogin;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLogin != null ? idLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login)) {
            return false;
        }
        Login other = (Login) object;
        if ((this.idLogin == null && other.idLogin != null) || (this.idLogin != null && !this.idLogin.equals(other.idLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.Login[ idLogin=" + idLogin + " ]";
    }
    
}
