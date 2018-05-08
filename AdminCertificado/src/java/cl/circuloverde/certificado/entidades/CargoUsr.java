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
@Table(name = "cargo_usr", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CargoUsr.findAll", query = "SELECT c FROM CargoUsr c")
    , @NamedQuery(name = "CargoUsr.findByIdCargoUsr", query = "SELECT c FROM CargoUsr c WHERE c.idCargoUsr = :idCargoUsr")
    , @NamedQuery(name = "CargoUsr.findByNomCargoUsr", query = "SELECT c FROM CargoUsr c WHERE c.nomCargoUsr = :nomCargoUsr")})
public class CargoUsr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cargo_usr", nullable = false)
    private Integer idCargoUsr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nom_cargo_usr", nullable = false, length = 15)
    private String nomCargoUsr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsrCv")
    private List<UsuarioCv> usuarioCvList;

    public CargoUsr() {
    }

    public CargoUsr(Integer idCargoUsr) {
        this.idCargoUsr = idCargoUsr;
    }

    public CargoUsr(Integer idCargoUsr, String nomCargoUsr) {
        this.idCargoUsr = idCargoUsr;
        this.nomCargoUsr = nomCargoUsr;
    }

    public Integer getIdCargoUsr() {
        return idCargoUsr;
    }

    public void setIdCargoUsr(Integer idCargoUsr) {
        this.idCargoUsr = idCargoUsr;
    }

    public String getNomCargoUsr() {
        return nomCargoUsr;
    }

    public void setNomCargoUsr(String nomCargoUsr) {
        this.nomCargoUsr = nomCargoUsr;
    }

    @XmlTransient
    public List<UsuarioCv> getUsuarioCvList() {
        return usuarioCvList;
    }

    public void setUsuarioCvList(List<UsuarioCv> usuarioCvList) {
        this.usuarioCvList = usuarioCvList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCargoUsr != null ? idCargoUsr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CargoUsr)) {
            return false;
        }
        CargoUsr other = (CargoUsr) object;
        if ((this.idCargoUsr == null && other.idCargoUsr != null) || (this.idCargoUsr != null && !this.idCargoUsr.equals(other.idCargoUsr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.CargoUsr[ idCargoUsr=" + idCargoUsr + " ]";
    }
    
}
