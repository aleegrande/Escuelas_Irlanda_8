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
@Table(name = "Cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c")
    , @NamedQuery(name = "Cursos.findByIdCurso", query = "SELECT c FROM Cursos c WHERE c.idCurso = :idCurso")
    , @NamedQuery(name = "Cursos.findByNombreCurso", query = "SELECT c FROM Cursos c WHERE c.nombreCurso = :nombreCurso")
    , @NamedQuery(name = "Cursos.findByNivel", query = "SELECT c FROM Cursos c WHERE c.nivel = :nivel")
    , @NamedQuery(name = "Cursos.findByNumeroAlumnos", query = "SELECT c FROM Cursos c WHERE c.numeroAlumnos = :numeroAlumnos")
    , @NamedQuery(name = "Cursos.findByPeriodo", query = "SELECT c FROM Cursos c WHERE c.periodo = :periodo")
    , @NamedQuery(name = "Cursos.findByProfesor", query = "SELECT c FROM Cursos c WHERE c.profesor = :profesor")
    , @NamedQuery(name = "Cursos.findByHorario", query = "SELECT c FROM Cursos c WHERE c.horario = :horario")})
public class Cursos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCurso")
    private Integer idCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombreCurso")
    private String nombreCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nivel")
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroAlumnos")
    private int numeroAlumnos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "profesor")
    private String profesor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "horario")
    private String horario;

    public Cursos() {
    }

    public Cursos(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Cursos(Integer idCurso, String nombreCurso, String nivel, int numeroAlumnos, String periodo, String profesor, String horario) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.nivel = nivel;
        this.numeroAlumnos = numeroAlumnos;
        this.periodo = periodo;
        this.profesor = profesor;
        this.horario = horario;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cursos[ idCurso=" + idCurso + " ]";
    }
    
}
