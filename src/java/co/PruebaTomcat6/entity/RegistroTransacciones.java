/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.PruebaTomcat6.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junior
 */
@Entity
@Table(name = "registro_transacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroTransacciones.findAll", query = "SELECT r FROM RegistroTransacciones r")
    , @NamedQuery(name = "RegistroTransacciones.findById", query = "SELECT r FROM RegistroTransacciones r WHERE r.id = :id")
    , @NamedQuery(name = "RegistroTransacciones.findByIdIngresoDeduccion", query = "SELECT r FROM RegistroTransacciones r WHERE r.idIngresoDeduccion = :idIngresoDeduccion")
    , @NamedQuery(name = "RegistroTransacciones.findByTipoTransaccion", query = "SELECT r FROM RegistroTransacciones r WHERE r.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "RegistroTransacciones.findByFecha", query = "SELECT r FROM RegistroTransacciones r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "RegistroTransacciones.findByMonto", query = "SELECT r FROM RegistroTransacciones r WHERE r.monto = :monto")
    , @NamedQuery(name = "RegistroTransacciones.findByEstado", query = "SELECT r FROM RegistroTransacciones r WHERE r.estado = :estado")
    , @NamedQuery(name = "RegistroTransacciones.findByIdAsiento", query = "SELECT r FROM RegistroTransacciones r WHERE r.idAsiento = :idAsiento")})
public class RegistroTransacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ingreso_deduccion")
    private int idIngresoDeduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo_transaccion")
    private Character tipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_asiento")
    private Integer idAsiento;
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados idEmpleado;

    public RegistroTransacciones() {
    }

    public RegistroTransacciones(Integer id) {
        this.id = id;
    }

    public RegistroTransacciones(Integer id, int idIngresoDeduccion, Character tipoTransaccion, Date fecha, BigDecimal monto, boolean estado) {
        this.id = id;
        this.idIngresoDeduccion = idIngresoDeduccion;
        this.tipoTransaccion = tipoTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdIngresoDeduccion() {
        return idIngresoDeduccion;
    }

    public void setIdIngresoDeduccion(int idIngresoDeduccion) {
        this.idIngresoDeduccion = idIngresoDeduccion;
    }

    public Character getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(Character tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdAsiento() {
        return idAsiento;
    }

    public void setIdAsiento(Integer idAsiento) {
        this.idAsiento = idAsiento;
    }

    public Empleados getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleados idEmpleado) {
        this.idEmpleado = idEmpleado;
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
        if (!(object instanceof RegistroTransacciones)) {
            return false;
        }
        RegistroTransacciones other = (RegistroTransacciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.PruebaTomcat6.entity.RegistroTransacciones[ id=" + id + " ]";
    }
    
}
