package upeu.edu.pe.ms_curso.mapper;

import upeu.edu.pe.ms_curso.dto.CursoDTO;
import upeu.edu.pe.ms_curso.entity.Curso;

public class CursoMapper {

    public static CursoDTO toDTO(Curso curso) {
        return new CursoDTO(
                curso.getId(),
                curso.getNombre(),
                curso.getCodigo(),
                curso.getCreditos()
        );
    }

    public static Curso toEntity(CursoDTO dto) {
        return new Curso(
                dto.getId(),
                dto.getNombre(),
                dto.getCodigo(),
                dto.getCreditos()
        );
    }
}