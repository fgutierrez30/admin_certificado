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
@Table(name = "holding", catalog = "certificado", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Holding.findAll", query = "SELECT h FROM Holding h")
    , @NamedQuery(name = "Holding.findByIdHolding", query = "SELECT h FROM Holding h WHERE h.idHolding = :idHolding")
    , @NamedQuery(name = "Holding.findByNomHolding", query = "SELECT h FROM Holding h WHERE h.nomHolding = :nomHolding")})
public class Holding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_holding", nullable = false)
    private Integer idHolding;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nom_holding", nullable = false, length = 80)
    private String nomHolding;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHolding")
    private List<Empresa> empresaList;

    public Holding() {
    }

    public Holding(Integer idHolding) {
        this.idHolding = idHolding;
    }

    public Holding(Integer idHolding, String nomHolding) {
        this.idHolding = idHolding;
        this.nomHolding = nomHolding;
    }

    public Integer getIdHolding() {
        return idHolding;
    }

    public void setIdHolding(Integer idHolding) {
        this.idHolding = idHolding;
    }

    public String getNomHolding() {
        return nomHolding;
    }

    public void setNomHolding(String nomHolding) {
        this.nomHolding = nomHolding;
    }

    @XmlTransient
    public List<Empresa> getEmpresaList() {
        return empresaList;
    }

    public void setEmpresaList(List<Empresa> empresaList) {
        this.empresaList = empresaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHolding != null ? idHolding.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Holding)) {
            return false;
        }
        Holding other = (Holding) object;
        if ((this.idHolding == null && other.idHolding != null) || (this.idHolding != null && !this.idHolding.equals(other.idHolding))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.circuloverde.certificado.entidades.Holding[ idHolding=" + idHolding + " ]";
    }
    
}
