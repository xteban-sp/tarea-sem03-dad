package upeu.edu.pe.ms_matricula.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MatriculaDTO {

    private Long id;

    @NotBlank(message = "El alumno es obligatorio")
    private String alumno;

    @NotNull(message = "El cursoId es obligatorio")
    private Long cursoId;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    public MatriculaDTO() {
    }

    public MatriculaDTO(Long id, String alumno, Long cursoId, LocalDate fecha) {
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
