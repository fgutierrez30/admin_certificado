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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "perfil_sii", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerfilSii.findAll", query = "SELECT p FROM PerfilSii p")
    , @NamedQuery(name = "PerfilSii.findByIdPerfil", query = "SELECT p FROM PerfilSii p WHERE p.idPerfil = :idPerfil")
    , @NamedQuery(name = "PerfilSii.findByNomPerfil", query = "SELECT p FROM PerfilSii p WHERE p.nomPerfil = :nomPerfil")})
public class PerfilSii implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private Integer idPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom_perfil", nullable = false, length = 50)
    private String nomPerfil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPerfil")
    private List<PerfilSiiRptLegal> perfilSiiRptLegalList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTpoPerfil")
    private List<PerfilSiiUsrCv> perfilSiiUsrCvList;

    public PerfilSii() {
    }

    public PerfilSii(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public PerfilSii(Integer idPerfil, String nomPerfil) {
        this.idPerfil = idPerfil;
        this.nomPerfil = nomPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomPerfil() {
        return nomPerfil;
    }

    public void setNomPerfil(String nomPerfil) {
        this.nomPerfil = nomPerfil;
    }

    @XmlTransient
    public List<PerfilSiiRptLegal> getPerfilSiiRptLegalList() {
        return perfilSiiRptLegalList;
    }

    public void setPerfilSiiRptLegalList(List<PerfilSiiRptLegal> perfilSiiRptLegalList) {
        this.perfilSiiRptLegalList = perfilSiiRptLegalList;
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
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilSii)) {
            return false;
        }
        PerfilSii other = (PerfilSii) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.PerfilSii[ idPerfil=" + idPerfil + " ]";
    }
    
}
