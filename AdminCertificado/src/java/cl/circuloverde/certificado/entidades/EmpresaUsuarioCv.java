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
@Table(name = "empresa_usuario_cv", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpresaUsuarioCv.findAll", query = "SELECT e FROM EmpresaUsuarioCv e")
    , @NamedQuery(name = "EmpresaUsuarioCv.findByIdEmpresaUsrCv", query = "SELECT e FROM EmpresaUsuarioCv e WHERE e.idEmpresaUsrCv = :idEmpresaUsrCv")
    , @NamedQuery(name = "EmpresaUsuarioCv.findByEstadoEmpUsrCv", query = "SELECT e FROM EmpresaUsuarioCv e WHERE e.estadoEmpUsrCv = :estadoEmpUsrCv")})
public class EmpresaUsuarioCv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa_usr_cv", nullable = false)
    private Integer idEmpresaUsrCv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_emp_usr_cv", nullable = false)
    private int estadoEmpUsrCv;
    @JoinColumn(name = "rut_usr_cv", referencedColumnName = "rut_usr_cv", nullable = false)
    @ManyToOne(optional = false)
    private UsuarioCv rutUsrCv;
    @JoinColumn(name = "rut_empresa", referencedColumnName = "rut_empresa", nullable = false)
    @ManyToOne(optional = false)
    private Empresa rutEmpresa;

    public EmpresaUsuarioCv() {
    }

    public EmpresaUsuarioCv(Integer idEmpresaUsrCv) {
        this.idEmpresaUsrCv = idEmpresaUsrCv;
    }

    public EmpresaUsuarioCv(Integer idEmpresaUsrCv, int estadoEmpUsrCv) {
        this.idEmpresaUsrCv = idEmpresaUsrCv;
        this.estadoEmpUsrCv = estadoEmpUsrCv;
    }

    public Integer getIdEmpresaUsrCv() {
        return idEmpresaUsrCv;
    }

    public void setIdEmpresaUsrCv(Integer idEmpresaUsrCv) {
        this.idEmpresaUsrCv = idEmpresaUsrCv;
    }

    public int getEstadoEmpUsrCv() {
        return estadoEmpUsrCv;
    }

    public void setEstadoEmpUsrCv(int estadoEmpUsrCv) {
        this.estadoEmpUsrCv = estadoEmpUsrCv;
    }

    public UsuarioCv getRutUsrCv() {
        return rutUsrCv;
    }

    public void setRutUsrCv(UsuarioCv rutUsrCv) {
        this.rutUsrCv = rutUsrCv;
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
        hash += (idEmpresaUsrCv != null ? idEmpresaUsrCv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaUsuarioCv)) {
            return false;
        }
        EmpresaUsuarioCv other = (EmpresaUsuarioCv) object;
        if ((this.idEmpresaUsrCv == null && other.idEmpresaUsrCv != null) || (this.idEmpresaUsrCv != null && !this.idEmpresaUsrCv.equals(other.idEmpresaUsrCv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.EmpresaUsuarioCv[ idEmpresaUsrCv=" + idEmpresaUsrCv + " ]";
    }
    
}
