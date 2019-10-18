/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

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
 * @author Leo
 */
@Entity
@Table(name = "Escuelas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escuelas.findAll", query = "SELECT e FROM Escuelas e")
    , @NamedQuery(name = "Escuelas.findByIdEscuela", query = "SELECT e FROM Escuelas e WHERE e.idEscuela = :idEscuela")
    , @NamedQuery(name = "Escuelas.findByNombreEscuela", query = "SELECT e FROM Escuelas e WHERE e.nombreEscuela = :nombreEscuela")
    , @NamedQuery(name = "Escuelas.findByDomicilio", query = "SELECT e FROM Escuelas e WHERE e.domicilio = :domicilio")
    , @NamedQuery(name = "Escuelas.findByTelefono", query = "SELECT e FROM Escuelas e WHERE e.telefono = :telefono")
    , @NamedQuery(name = "Escuelas.findByNumeroAlumnos", query = "SELECT e FROM Escuelas e WHERE e.numeroAlumnos = :numeroAlumnos")
    , @NamedQuery(name = "Escuelas.findByFundacion", query = "SELECT e FROM Escuelas e WHERE e.fundacion = :fundacion")})
public class Escuelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEscuela")
    private Integer idEscuela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreEscuela")
    private String nombreEscuela;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "domicilio")
    private String domicilio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroAlumnos")
    private int numeroAlumnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "Fundacion")
    private String fundacion;

    public Escuelas() {
    }

    public Escuelas(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public Escuelas(Integer idEscuela, String nombreEscuela, String domicilio, String telefono, int numeroAlumnos, String fundacion) {
        this.idEscuela = idEscuela;
        this.nombreEscuela = nombreEscuela;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.numeroAlumnos = numeroAlumnos;
        this.fundacion = fundacion;
    }

    public Integer getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getFundacion() {
        return fundacion;
    }

    public void setFundacion(String fundacion) {
        this.fundacion = fundacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEscuela != null ? idEscuela.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escuelas)) {
            return false;
        }
        Escuelas other = (Escuelas) object;
        if ((this.idEscuela == null && other.idEscuela != null) || (this.idEscuela != null && !this.idEscuela.equals(other.idEscuela))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Escuelas[ idEscuela=" + idEscuela + " ]";
    }
    
}
