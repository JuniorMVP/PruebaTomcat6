/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.PruebaTomcat6.entity;

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
 * @author junior
 */
@Entity
@Table(name = "tipos_ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TiposIngresos.findAll", query = "SELECT t FROM TiposIngresos t")
    , @NamedQuery(name = "TiposIngresos.findById", query = "SELECT t FROM TiposIngresos t WHERE t.id = :id")
    , @NamedQuery(name = "TiposIngresos.findByNombre", query = "SELECT t FROM TiposIngresos t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TiposIngresos.findByDependeSalario", query = "SELECT t FROM TiposIngresos t WHERE t.dependeSalario = :dependeSalario")
    , @NamedQuery(name = "TiposIngresos.findByEstado", query = "SELECT t FROM TiposIngresos t WHERE t.estado = :estado")})
public class TiposIngresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "depende_salario")
    private boolean dependeSalario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;

    public TiposIngresos() {
    }

    public TiposIngresos(Integer id) {
        this.id = id;
    }

    public TiposIngresos(Integer id, String nombre, boolean dependeSalario, boolean estado) {
        this.id = id;
        this.nombre = nombre;
        this.dependeSalario = dependeSalario;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getDependeSalario() {
        return dependeSalario;
    }

    public void setDependeSalario(boolean dependeSalario) {
        this.dependeSalario = dependeSalario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposIngresos)) {
            return false;
        }
        TiposIngresos other = (TiposIngresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.PruebaTomcat6.entity.TiposIngresos[ id=" + id + " ]";
    }
    
}
