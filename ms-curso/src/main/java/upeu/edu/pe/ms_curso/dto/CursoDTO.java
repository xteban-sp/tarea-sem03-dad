package upeu.edu.pe.ms_curso.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CursoDTO {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El codigo es obligatorio")
    private String codigo;

    @NotNull(message = "Los creditos son obligatorios")
    @Min(value = 1, message = "Los creditos deben ser mayores a 0")
    private Integer creditos;

    public CursoDTO() {
    }

    public CursoDTO(Long id, String nombre, String codigo, Integer creditos) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}