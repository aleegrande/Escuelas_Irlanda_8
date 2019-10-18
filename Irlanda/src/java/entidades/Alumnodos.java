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
@Table(name = "alumnodos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnodos.findAll", query = "SELECT a FROM Alumnodos a")
    , @NamedQuery(name = "Alumnodos.findByIdalumno", query = "SELECT a FROM Alumnodos a WHERE a.idalumno = :idalumno")
    , @NamedQuery(name = "Alumnodos.findByNombrealumno", query = "SELECT a FROM Alumnodos a WHERE a.nombrealumno = :nombrealumno")
    , @NamedQuery(name = "Alumnodos.findByNombreusuario", query = "SELECT a FROM Alumnodos a WHERE a.nombreusuario = :nombreusuario")
    , @NamedQuery(name = "Alumnodos.findByFechanacimiento", query = "SELECT a FROM Alumnodos a WHERE a.fechanacimiento = :fechanacimiento")
    , @NamedQuery(name = "Alumnodos.findByNacionalidad", query = "SELECT a FROM Alumnodos a WHERE a.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Alumnodos.findByTelefono", query = "SELECT a FROM Alumnodos a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Alumnodos.findByCorreo", query = "SELECT a FROM Alumnodos a WHERE a.correo = :correo")})
public class Alumnodos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idalumno")
    private Integer idalumno;
    @Size(max = 100)
    @Column(name = "nombrealumno")
    private String nombrealumno;
    @Size(max = 50)
    @Column(name = "nombreusuario")
    private String nombreusuario;
    @Size(max = 15)
    @Column(name = "fechanacimiento")
    private String fechanacimiento;
    @Size(max = 30)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;

    public Alumnodos() {
    }

    public Alumnodos(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalumno != null ? idalumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnodos)) {
            return false;
        }
        Alumnodos other = (Alumnodos) object;
        if ((this.idalumno == null && other.idalumno != null) || (this.idalumno != null && !this.idalumno.equals(other.idalumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Alumnodos[ idalumno=" + idalumno + " ]";
    }
    
}
