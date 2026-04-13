package upeu.edu.pe.ms_matricula.mapper;

import upeu.edu.pe.ms_matricula.dto.MatriculaDTO;
import upeu.edu.pe.ms_matricula.entity.Matricula;

public class MatriculaMapper {

    public static MatriculaDTO toDTO(Matricula matricula) {
        return new MatriculaDTO(
                matricula.getId(),
                matricula.getAlumno(),
                matricula.getCursoId(),
                matricula.getFecha()
        );
    }

    public static Matricula toEntity(MatriculaDTO dto) {
        return new Matricula(
                dto.getId(),
                dto.getAlumno(),
                dto.getCursoId(),
                dto.getFecha()
        );
    }
}