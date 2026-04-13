package upeu.edu.pe.ms_matricula.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alumno;
    private Long cursoId;
    private LocalDate fecha;

    public Matricula() {
    }

    public Matricula(Long id, String alumno, Long cursoId, LocalDate fecha) {
        this.id = id;
        this.alumno = alumno;
        this.cursoId = cursoId;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public String getAlumno() {
        return alumno;
    }

    public Long getCursoId() {
        return cursoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}